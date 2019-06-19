package com.example.customview.draw_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.Log
import android.view.View
import com.example.customview.PaintUtil

/**
 * 平移
 * @author wzw
 * @date 2019/5/23 15:31
 */
class SkewView(context: Context) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.LTGRAY)
        canvas?.drawRect(100f, 0f, 300f, 100f, PaintUtil.genaratePaint(Color.GREEN))

        //Y轴向X轴方向转（逆时针）60度
        canvas?.skew(Math.sqrt(3.0).toFloat(), 0f)
        //X轴向Y轴方向转（顺时针）45度
//        canvas?.skew(0f, 1f)
        canvas?.drawRect(100f, 0f, 300f, 100f, PaintUtil.genaratePaint())
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, height)
    }


    init {
        Log.e("=--===", "" + add(10))
    }

    private fun add(i: Int): Int {
        if (i == 1) {
            return i
        }
        return i + add(i - 1)
    }
}