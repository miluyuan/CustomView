package com.example.customview.draw.draw_6

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * 波浪效果
 * @author wzw
 * @date 2019/5/29 16:48
 */
class WaveView(context: Context) : View(context) {
    private var mPaint: Paint
    private var mPath: Path
    private val mItemWaveLength = 400

    init {
        mPath = Path()
        mPaint = Paint()
        mPaint.color = Color.GREEN
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        startAnim()
    }

    var dx = 0
    var dy = 0
    private fun startAnim() {
        val animator = ValueAnimator.ofInt(0, mItemWaveLength)
        animator.duration = (1000)
        animator.addUpdateListener {
            dx = it.animatedValue as Int
            postInvalidate()
        }
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.start()

        val animator2 = ValueAnimator.ofInt(0, measuredHeight)
        animator2.duration = (8000)
        animator2.addUpdateListener {
            dy = it.animatedValue as Int
            postInvalidate()
        }
        animator2.repeatCount = ValueAnimator.INFINITE
        animator2.repeatMode = ValueAnimator.REVERSE
        animator2.interpolator = LinearInterpolator()
        animator2.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.LTGRAY)

        mPath.reset()
        val originY = 300
        val halfWaveLen = mItemWaveLength / 2
        mPath.moveTo((-mItemWaveLength + dx).toFloat(), dy.toFloat())
        var i = -mItemWaveLength
        while (i <= width + mItemWaveLength) {
            mPath.rQuadTo((halfWaveLen / 2).toFloat(), -50f, halfWaveLen.toFloat(), 0f)
            mPath.rQuadTo((halfWaveLen / 2).toFloat(), 50f, halfWaveLen.toFloat(), 0f)
            i += mItemWaveLength
        }
        mPath.lineTo(width.toFloat(), height.toFloat())
        mPath.lineTo(0f, height.toFloat())
        mPath.close()

        canvas.drawPath(mPath, mPaint)
    }

}