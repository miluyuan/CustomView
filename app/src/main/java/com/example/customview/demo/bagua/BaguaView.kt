package com.example.customview.demo.bagua

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.atan
import kotlin.math.min

/**
 * 八卦图
 * @author wzw
 * @date 2019/6/18 16:09
 */
class BaguaView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private var bigRadius = 0f
    private var midRadius = 0f
    private var smallRadius = 0f
    private var cx = 0f
    private var cy = 0f
    private val paint = Paint()
    private var valueAnimator: ValueAnimator
    private lateinit var bigRectF: RectF
    private lateinit var midTopRect: RectF
    private lateinit var midBottomRect: RectF
    private lateinit var smallTopRectF: RectF
    private lateinit var smallBottomRectF: RectF
    private var startDegree = 0f
    private var degree = 0f
    //转一周用时，单位秒/转
    private var cycleTime = 10L
    private var list = ArrayList<Point>(10)
    //正负系数(正:顺时针转)
    private var factor = 1

    init {
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true

        valueAnimator = ValueAnimator.ofFloat(360f).apply {
            duration = cycleTime * 1000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            interpolator = LinearInterpolator()
        }
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            degree = startDegree + value * factor
//            println("####$degree")
            invalidate()
        }
    }

    private val cenPoint = Point()
    private val firstPoint = Point()
    private val secondPoint = Point()

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                stop()
                firstPoint.x = event.x
                firstPoint.y = event.y
                firstPoint.time = System.currentTimeMillis()
                list.clear()
                add2List(firstPoint)
//                println("down")
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                secondPoint.x = event.x
                secondPoint.y = event.y
                secondPoint.time = System.currentTimeMillis()
                add2List(secondPoint)
                val degre = getDegree(cenPoint, firstPoint, secondPoint).toFloat()
                if (degre != 0f) {
                    println("move，$degre")
                    degree += degre
                    startDegree = degree % 360
                    invalidate()

//                first = second
                    firstPoint.set(secondPoint)
                }
            }
            MotionEvent.ACTION_UP -> {
                if (list.size < 6) {
                    return super.onTouchEvent(event)
                }
                firstPoint.set(list.first())
                secondPoint.set(list.last())
                val degre = getDegree(cenPoint, firstPoint, secondPoint).toFloat()
                println("action_up: $degre")
                if (degre != 0f) {
                    cycleTime = ((secondPoint.time - firstPoint.time) * 360 / degre).toLong()
                    if (cycleTime < 0) {
                        factor = -1
                        cycleTime = -cycleTime
                    } else {
                        factor = 1
                    }
                    valueAnimator.duration = cycleTime
                    start()
                }

                println("cycleTime=$cycleTime")
            }
        }
        return super.onTouchEvent(event)
    }

    private fun add2List(point: Point) {

        if (list.size == 10) {
            list.removeAt(0)
        }
        val p = Point(point)
        list.add(p)
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        println("=====================================onMeasure")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        cx = measureWidth / 2.toFloat()
        cy = measureHeight / 2.toFloat()
        cenPoint.x = cx
        cenPoint.y = cy
        bigRadius = min(measureHeight, measureWidth) / 2.toFloat()
        midRadius = bigRadius / 2
        smallRadius = midRadius / 3

        bigRectF = RectF(cx - bigRadius, cy - bigRadius, cx + bigRadius, cy + bigRadius)

        smallTopRectF = RectF(cx - smallRadius, cy - smallRadius * 4, cx + smallRadius, cy - smallRadius * 2)
        smallBottomRectF = RectF(cx - smallRadius, cy + smallRadius * 2, cx + smallRadius, cy + smallRadius * 4)

        midTopRect = RectF(cx - midRadius, cy - bigRadius, cx + midRadius, cy)
        midBottomRect = RectF(cx - midRadius, cy, cx + midRadius, cy + bigRadius)

        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.rotate(degree, cx, cy)
        drawBig(canvas)
        drawMid(canvas)
        drawSmall(canvas)
//        println("onDraw")
    }

    private fun drawBig(canvas: Canvas) {
        //右半圆黑色
        paint.color = Color.BLACK
        canvas.drawArc(bigRectF, -90f, 180f, false, paint)
        //左半圆白色
        paint.color = Color.WHITE
        canvas.drawArc(bigRectF, 90f, 180f, false, paint)
    }

    private fun drawMid(canvas: Canvas) {
        //原本只画半圆就可以了，但paint抗锯齿且旋转动画后半圆直径位置会有线
        //画两个黑白圆
        paint.color = Color.WHITE
        canvas.drawArc(midTopRect, -90f, 360f, false, paint)
        paint.color = Color.BLACK
        canvas.drawArc(midBottomRect, 90f, 360f, false, paint)
    }

    private fun drawSmall(canvas: Canvas) {
        paint.color = Color.BLACK
        canvas.drawArc(smallTopRectF, 0f, 360f, false, paint)
        paint.color = Color.WHITE
        canvas.drawArc(smallBottomRectF, 0f, 360f, false, paint)
    }

    public fun start() {
        valueAnimator.start()
    }

    public fun stop() {
        valueAnimator.cancel()
        startDegree = degree % 360
    }

    private fun getDegree(cen: Point, first: Point, second: Point): Double {
        if (first.x == second.x && first.y == second.y) {
            return 0.0
        }
        val x1 = first.x - cen.x.toDouble()
        val y1 = first.y - cen.y.toDouble()
        val x2 = second.x - cen.x.toDouble()
        val y2 = second.y - cen.y.toDouble()

        val atan1 = quadrantAngle(x1, y1)
        val atan2 = quadrantAngle(x2, y2)

        println("atan1,2============($atan1, $atan2)")
//        println("atan2============$atan2")
        var toDegrees = Math.toDegrees((atan2 - atan1))
        //解决x1>0,x2>0, y1*y2<0时会朝相反方向快速转动
        if (toDegrees > 180) {
            toDegrees -= 360.0
        } else if (toDegrees < -180) {
            toDegrees += 360
        }
        return toDegrees
    }

    /**
     * 象限角度换算
     * 与x轴正方向的顺时针夹角
     */
    private fun quadrantAngle(x: Double, y: Double): Double {
        val angle = atan(y / x)
        //角度在0到2π之间，需区分象限
        return if (x > 0 && y > 0) {
            angle
        } else if (x > 0 && y < 0) {
            angle + 2 * Math.PI
        } else if (x < 0 && y > 0) {
            angle + Math.PI
        } else {
            // (x < 0 && y < 0)
            angle + Math.PI
        }
    }

    public fun cancel() {
        valueAnimator.cancel()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public fun pause() {
        valueAnimator.pause()
    }
}