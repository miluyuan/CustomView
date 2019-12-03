package com.example.customview.draw.draw_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import com.example.customview.PaintUtil

/**
 * 平移
 * @author wzw
 * @date 2019/5/23 15:31
 */
class RotateView(context: Context):View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.rotate(30f)
        canvas?.drawColor(Color.LTGRAY)

        canvas?.drawRect(100f, 0f, 300f, 100f, PaintUtil.genaratePaint())
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, height)
    }
}