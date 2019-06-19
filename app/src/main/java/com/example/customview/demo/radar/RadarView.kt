package com.example.customview.demo.radar

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator

/**
 *
 * @author wzw
 * @date 2019/6/17 10:32
 */
class RadarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {
    private var measureWith = 0
    private var measureHeight = 0
    private var maxRadius = 0
    private var spacing = 64
    private var cx = 0
    private var cy = 0
    private var spaceLineCount = 0
    private var paint = Paint()
    private var radarPaint = Paint()

    init {
        val animator = ObjectAnimator.ofInt(0, 360 * 2)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.RESTART
        animator.interpolator = LinearInterpolator()
        animator.duration = 40000
        animator.addUpdateListener {
            val interval = it.animatedValue as Int
            Log.e("addUpdateListener", interval.toString())
            a = interval
            invalidate()
        }
        animator.start()
    }


    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        measureWith = MeasureSpec.getSize(widthMeasureSpec)
        measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val d = measureWith * measureWith.toDouble() + measureHeight * measureHeight.toDouble()
        maxRadius = Math.sqrt(d).toInt() / 2
        cx = measureWith / 2
        cy = measureHeight / 2
        spaceLineCount = maxRadius / spacing

        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        //0xFF0000FF
        radarPaint.color = t.toInt()
        radarPaint.style = Paint.Style.FILL
        rectF = RectF(cx - cy.toFloat(), 0f, cx + cy.toFloat(), measureHeight.toFloat())
        Log.e("Radar", (Color.BLUE == t.toInt()).toString())
    }

    var t = 0x000000FF
    var a = 0
    var startAngle = 0f
    var sweepAngle = 1f
    var rectF = RectF()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        for (i in 1..spaceLineCount) {
//            val radius = spacing * i
//            canvas.drawCircle(cx.toFloat(), cy.toFloat(), radius.toFloat(), paint)
//        }

        var color = 0
        var start = a / 2
        var end = (a / 2 + 360)
        startAngle = a/2.toFloat()
        var l = 0
        for (i in start..end) {
            l = ((i - a) * 255 / 360) shl (6 * 4)
            color = t or l
        }

        start = a
        end = a + 360
        for (i in 0..end) {
            l = ((i%360) * 255 / 360) shl (6 * 4)
            color = t or l
            radarPaint.color = color
            canvas.drawArc(rectF, startAngle, sweepAngle, true, radarPaint)
            startAngle += sweepAngle
        }

    }

}