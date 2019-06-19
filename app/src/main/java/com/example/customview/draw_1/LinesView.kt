package com.example.customview.draw_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/15 10:40
 */
class LinesView(context: Context) : View(context) {
    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.color = Color.BLUE
        paint.strokeWidth = 5f
        paint.style = Paint.Style.FILL
        //设置阴影，radius是个模糊度，如果设置0f,则没有阴影
        paint.setShadowLayer(0f, 20f, 40f, Color.GREEN)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //两条线：[(10f, 10f),(100f, 100f)]和[(101f, 110f),(400f, 400f)]
        val pts = floatArrayOf(10f, 10f, 100f, 100f, 101f, 110f, 400f, 400f)
        canvas?.drawLines(pts, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMea = MeasureSpec.makeMeasureSpec(400, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMea)
    }
}