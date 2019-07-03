package com.example.customview.demo.pendulum

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * 单摆时间与夹角公式
 * α = θ*cos(2π/T*t);
 * 其中，α为单摆与垂直方向的夹角，θ为最大夹角，T为周期，t为时间
 * 单摆周期：T=2π√(l/g); 其中l为摆长，g为重力加速度
 * @author wzw
 * @date 2019/7/3 10:00
 */
class PendulumView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    //摆长
    private var l = 0f
    //小球位置
    private var bx = 0f
    private var by = 0f
    private var maxAngle = (30f / 180) * Math.PI
    private var ballRadius = 48f
    //顶点
    private var cx = 0f
    private var cy = 0f
    //周期
    private var T = 0f
    //重力加速度m/s²
    private var g = 10f

    private val paint = Paint()
    private val animator = ValueAnimator.ofFloat(0f, 1f)

    init {
        paint.isAntiAlias = true
        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        animator.apply {
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE

            addUpdateListener {
                val value = it.animatedValue as Float
                val t = value * duration / 1000
                val angle = maxAngle * cos(t * sqrt((g / l).toDouble()))
                bx = (l * sin(angle)).toFloat()
                by = (l * cos(angle)).toFloat()
                invalidate()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)

        //将重力加速度的单位转为px/s²
        // value * metrics.xdpi * (1.0f/25.4f) = mm
        val displayMetrics = getContext().resources.displayMetrics
        //m/px，由于手机屏幕很小，摆长放大1000倍
        var meter = 1 * 1000 / (displayMetrics.xdpi * (1.0f / 25.4f) * 1000)
        //px/s²
        g /= meter

        l = (measureWidth - ballRadius)
        bx = (l * sin(maxAngle)).toFloat()
        by = (l * cos(maxAngle)).toFloat()
        cx = measureWidth / 2f
        cy = 0f
        T = (2 * Math.PI * (sqrt((l / g).toDouble()))).toFloat()
        animator.duration = (T * 1000 / 4).toLong()
        println(meter * l)
        println("T=$T")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画支点
        canvas.drawCircle(cx, cy, 10f, paint)

        //画球
        val x = (cx + bx)
        paint.style = Paint.Style.FILL
        canvas.drawCircle(x, by, ballRadius, paint)

        //画线
        canvas.drawLine(cx, cy, x, by, paint)

        //画球轨迹
        paint.style = Paint.Style.STROKE
        canvas.drawCircle(cx, cy, l, paint)
    }

    public fun start() {

        animator.start()
    }
}