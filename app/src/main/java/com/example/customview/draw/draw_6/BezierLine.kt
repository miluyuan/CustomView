package com.example.customview.draw.draw_6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

/**
 * 贝塞尔曲线
 * @author wzw
 * @date 2019/5/29 14:57
 */
class BezierLine(context: Context) : View(context) {
    val paint = Paint()
    val pathBezier = Path()
    val pathLine = Path()

    init {
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        pathBezier.moveTo(50f, 50f)
        pathBezier.quadTo(50f, 300f, 800f, 50f)
        canvas?.drawPath(pathBezier, paint)

        paint.color = Color.RED
        pathLine.moveTo(50f, 50f)
        pathLine.lineTo(50f, 300f)
        pathLine.lineTo(800f, 50f)
        canvas?.drawPath(pathLine, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val h = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        setMeasuredDimension(widthMeasureSpec, h)
    }
}