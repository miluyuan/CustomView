package com.example.customview.draw.draw_4

import android.content.Context
import android.graphics.Canvas
import android.view.View
import com.example.customview.PaintUtil

/**
 * 平移
 * @author wzw
 * @date 2019/5/23 15:31
 */
class TranslateView(context: Context):View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.translate(100f, 100f)

        canvas?.drawRect(0f, 0f, 200f, 100f, PaintUtil.genaratePaint())
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, height)
    }
}