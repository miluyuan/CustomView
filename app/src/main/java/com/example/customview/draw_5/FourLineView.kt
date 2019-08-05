package com.example.customview.draw_5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/24 16:32
 */
class FourLineView(context: Context) : View(context) {

    val paint = Paint()
    val baseLineX = 40f
    val baseLineY = 220f
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.LTGRAY)
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.textSize = 160f
        canvas?.drawText("我爱AI google!", baseLineX, baseLineY, paint)



        val fontMetrics = paint.fontMetrics

        val top = baseLineY + fontMetrics.top
        val bottom = baseLineY + fontMetrics.bottom
        val ascent = baseLineY + fontMetrics.ascent
        val descent = baseLineY + fontMetrics.descent

        paint.color = Color.RED
        canvas?.drawLine(baseLineX, top, 1080f, top, paint)
        paint.color = Color.BLACK
        canvas?.drawLine(baseLineX, ascent, 1080f, ascent, paint)
        paint.color = Color.GREEN
        canvas?.drawLine(baseLineX, baseLineY, 1080f, baseLineY, paint)
        paint.color = Color.RED
        canvas?.drawLine(baseLineX, descent, 1080f, descent, paint)
        paint.color = Color.BLUE
        canvas?.drawLine(baseLineX, bottom, 1080f, bottom, paint)



    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        setMeasuredDimension(widthMeasureSpec, height)
    }
}