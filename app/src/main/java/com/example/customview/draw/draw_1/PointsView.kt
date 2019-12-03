package com.example.customview.draw.draw_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/15 11:20
 */
class PointsView(context: Context) : View(context) {
    private val paint: Paint = Paint()

    init {
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //一个点
//        canvas?.drawPoint(20f, 20f, paint)

        //多个点
        val floatArrayOf = floatArrayOf(40f, 40f, 80f, 80f, 80f, 40f, 100f, 40f)
//        canvas?.drawPoints(floatArrayOf, paint)
        //选取从floatArray的offset索引开始的count的值作为点
        canvas?.drawPoints(floatArrayOf,1, 2, paint)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMea = MeasureSpec.makeMeasureSpec(400, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMea)
    }
}