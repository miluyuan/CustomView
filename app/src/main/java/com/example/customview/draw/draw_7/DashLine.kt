package com.example.customview.draw.draw_7

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.view.View
import android.view.animation.LinearInterpolator

/**
 *
 * @author wzw
 * @date 2019/5/30 14:09
 */
class DashLine(context: Context) : View(context) {
    val paint = Paint()
    val path = Path()
    val realWidth = 20f
    val gapWith = 10f
    var phase = 0f
    val animator = ValueAnimator.ofFloat(realWidth + gapWith)

    init {
        paint.pathEffect = DashPathEffect(floatArrayOf(realWidth, gapWith), phase)
        paint.strokeWidth = 3f
        paint.color = Color.RED
        path.moveTo(100f, 100f)
        path.lineTo(1000f, 100f)
        paint.style = Paint.Style.STROKE

        animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 1000
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            phase = it.animatedValue as Float
            paint.pathEffect = DashPathEffect(floatArrayOf(realWidth, gapWith), phase)
            invalidate()
        }
        animator.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(200, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        //drawLine没有虚线效果
        //canvas.drawLine(10f,100f, 1000f, 100f, paint)
        canvas.drawPath(path, paint)


        paint.color = Color.parseColor("#3300FF00")
        canvas.drawLine(100f, 0f, 100f, 300f, paint)
    }
}