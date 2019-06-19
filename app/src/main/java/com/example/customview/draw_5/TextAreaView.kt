package com.example.customview.draw_5

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/24 16:32
 */
class TextAreaView(context: Context) : View(context) {

    val paint = Paint()
    val baseLineX = 40f
    val baseLineY = 220f
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.textSize = 160f
        val text = "lHello google!"
        canvas?.drawText(text, baseLineX, baseLineY, paint)


        //最小矩形
        paint.color = Color.RED
        val rect = Rect()
        paint.getTextBounds(text, 0, text.length, rect)
        paint.style = Paint.Style.STROKE
        val rect2 = RectF(rect.left + baseLineX, rect.top + baseLineY,
                rect.right + baseLineX, rect.bottom + baseLineY)
        canvas?.drawRect(rect2, paint)


        //Text所占区域
        paint.color = Color.GREEN
        val fontMetrics = paint.fontMetrics
        val height = fontMetrics.bottom - fontMetrics.top
        val width = paint.measureText(text)
        canvas?.drawRect(baseLineX, baseLineY + fontMetrics.top, baseLineX + width,
                baseLineY + fontMetrics.bottom, paint)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        setMeasuredDimension(widthMeasureSpec, height)
    }
}