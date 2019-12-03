package com.example.customview.draw.draw_1

import android.content.Context
import android.graphics.*
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/15 10:40
 */
class RectView(context: Context) : View(context) {
    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.color = Color.BLUE
        paint.strokeWidth = 5f
        paint.style = Paint.Style.FILL
        //设置阴影，radius是个模糊度，如果设置0f,则没有阴影
        paint.setShadowLayer(0f, 20f, 40f, Color.GREEN)

    }

    private val rect = RectF(120f, 10f, 210f, 100f)
    private val rect2 = Rect(230, 10, 320, 100)
    private val rectRound = Rect(400, 10, 10, 300)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //
//        canvas?.drawRect(10f, 10f, 200f, 100f, paint)
        //使用RectF构造
//        canvas?.drawRect(rect, paint)
//        //使用Rect构造
//        canvas?.drawRect(rect2, paint)

        paint.color = Color.BLUE
        canvas?.drawRoundRect(RectF(rectRound) , 50f, 100f,paint)
        paint.color = Color.RED
        canvas?.drawOval(RectF(rectRound), paint)
        //sweepAngle弧持续的角度
        canvas?.drawArc(400f, 10f, 800f, 400f, 270f, 90f,
                false, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMea = MeasureSpec.makeMeasureSpec(400, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMea)
    }
}