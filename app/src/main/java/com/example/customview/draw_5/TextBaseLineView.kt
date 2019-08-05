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
class TextBaseLineView(context: Context):View(context) {

    val paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.RED
        canvas?.drawLine(100f, 100f, 1080f, 100f, paint)
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.textSize = 120f
        //从文本的右端开始往左绘制
        paint.textAlign = Paint.Align.RIGHT
        canvas?.drawText("lHello google!", width/2f, 100f, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        setMeasuredDimension(widthMeasureSpec, height)
    }
}