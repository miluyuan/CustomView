package com.example.customview

import android.content.Context
import android.graphics.Color
import android.graphics.Paint

/**
 *
 * @author wzw
 * @date 2019/5/23 15:34
 */
object PaintUtil {
    fun genaratePaint(color: Int = Color.RED, style: Paint.Style = Paint.Style.FILL, strokeWidth: Float = 2f): Paint {
        val paint = Paint()
        paint.color = color
        paint.style = style
        paint.strokeWidth = strokeWidth
        return paint
    }

    fun dip2Px(context: Context, dip: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dip.toFloat() * density + 0.5f).toInt()
    }
}