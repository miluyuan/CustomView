package com.example.customview.demo.bagua

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 *
 * @author wzw
 * @date 2019/6/18 16:09
 */
class BaguaView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private var outRadius = 0f
    private var midRadius = 0f
    private var innerRadius = 0f
    private var cx = 0f
    private var cy = 0f
    private val paint = Paint()
    private var valueAnimator: ValueAnimator

    init {
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.isAntiAlias = true

        valueAnimator = ObjectAnimator.ofFloat(360f).apply {
            duration = 10 * 1000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
            interpolator = LinearInterpolator()

        }
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            rotation = value
        }

    }

    lateinit var topRect: RectF
    lateinit var bottomRect: RectF
    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        cx = measureWidth / 2.toFloat()
        cy = measureHeight / 2.toFloat()
        outRadius = Math.min(measureHeight, measureWidth) / 2.toFloat()
        midRadius = outRadius / 2
        innerRadius = midRadius / 3

        topRect = RectF(cx - midRadius, cy - outRadius, cx + midRadius, cy)
        bottomRect = RectF(cx - midRadius, cy, cx + midRadius, cy + outRadius)

        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawOut(canvas)
        drawMid(canvas)
        drawInner(canvas)
//        canvas.rotate(degree, cx, cy)
    }

    private fun drawOut(canvas: Canvas) {

        paint.color = Color.BLACK
        val rect = RectF(cx - outRadius, cy - outRadius, cx + outRadius, cy + outRadius)
        canvas.drawArc(rect, -90f, 180f, false, paint)
        paint.color = Color.WHITE
        canvas.drawArc(rect, 90f, 180f, false, paint)
    }

    private fun drawMid(canvas: Canvas) {
        paint.color = Color.WHITE
        canvas.drawArc(topRect, -90f, 360f, false, paint)
        paint.color = Color.BLACK
        canvas.drawArc(bottomRect, 90f, 360f, false, paint)
    }

    private fun drawInner(canvas: Canvas) {
        paint.color = Color.BLACK
        val innerCyTop = cy - midRadius
        canvas.drawCircle(cx, innerCyTop, innerRadius, paint)

        paint.color = Color.WHITE
        val innerCyBottom = cy + midRadius
        canvas.drawCircle(cx, innerCyBottom, innerRadius, paint)
    }


}