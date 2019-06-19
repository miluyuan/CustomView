package com.example.customview.draw_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.customview.PaintUtil

/**
 * 平移
 * @author wzw
 * @date 2019/5/23 15:31
 */
class ScaleView(context: Context):View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(100f, 100f, 300f, 200f, PaintUtil.genaratePaint(Color.GREEN, Paint.Style.STROKE, 4f))

        canvas?.scale(0.5f, 1f)
        canvas?.drawRect(100f, 100f, 300f, 200f, PaintUtil.genaratePaint(Color.BLUE, Paint.Style.STROKE, 4f))
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, height)
    }
}