package com.example.customview.draw.draw_2

import android.content.Context
import android.graphics.*
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/15 14:10
 */
class PathView(context: Context, val type: String) : View(context) {

    val paint = Paint()
    private val pathCCW = Path()
    private val pathCW = Path()

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 6f
        paint.setShadowLayer(10f, 10f, 10f, Color.GREEN)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        when (type) {
            直线路径 -> {
                pathCCW.moveTo(10f, 10f)
                pathCCW.lineTo(10f, 100f)
                pathCCW.lineTo(100f, 10f)
                pathCCW.close()
                canvas?.drawPath(pathCCW, paint)
            }
            矩形路径 -> {
                pathCCW.addRect(32f, 32f, 332f, 232f, Path.Direction.CW)
                pathCW.addRect(400f, 32f, 700f, 232f, Path.Direction.CW)

                paint.color = Color.RED
                //Path.Direction.CCW：逆时针，Path.Direction.CW：顺时针
                canvas?.drawPath(pathCCW, paint)
                canvas?.drawPath(pathCW, paint)

                paint.strokeWidth = 2f
                paint.color = Color.BLACK
                paint.textSize = 35f
                val text = "生成方式的区别在于，依据生成方向排版的文字！后面我们会，"
                canvas?.drawTextOnPath(text, pathCCW, 24f, 0f, paint)
                canvas?.drawTextOnPath(text, pathCW, 0f, 18f, paint)
            }
            圆角矩形路径 -> {
                pathCCW.addRoundRect(32f, 32f, 332f, 232f, 8f, 8f, Path.Direction.CCW)
                canvas?.drawPath(pathCCW, paint)
            }
            圆形路径 -> {
                paint.isAntiAlias = false
                pathCCW.addCircle(232f, 200f, 100f, Path.Direction.CCW)
                canvas?.drawPath(pathCCW, paint)
            }
            椭圆路径 -> {
                pathCCW.addOval(32f, 32f, 332f, 232f, Path.Direction.CCW)
                canvas?.drawPath(pathCCW, paint)
            }
            弧形路径 -> {
            }
            线段轨迹 -> {
                var left = 10f
                var top = 10f
                var r = 50f
                var side = 360f
                pathCCW.addArc(RectF(0f + left, 0f + top, 2 * r + left, 2 * r + top), 180f, 90f)
                pathCCW.lineTo(side - r + left, 0f + top)
                pathCCW.addArc(RectF(side - 2 * r + left, 0f + top, side + left, 2 * r + top), -90f, 90f)
                canvas?.drawPath(pathCCW, paint)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMea = MeasureSpec.makeMeasureSpec(400, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMea)
    }

    companion object {
        const val 直线路径 = "直线路径"
        const val 矩形路径 = "矩形路径"
        const val 圆角矩形路径 = "圆角矩形路径"
        const val 圆形路径 = "圆形路径"
        const val 椭圆路径 = "椭圆路径"
        const val 弧形路径 = "弧形路径"
        const val 线段轨迹 = "线段轨迹"
    }
}