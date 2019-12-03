package com.example.customview.draw.draw_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View

/**
 * @author wzw
 * @date 2019/5/15 15:46
 */
class DrawTextView(context: Context) : View(context) {
    private val paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.color = Color.RED
        paint.strokeWidth = 80f
        paint.textSize = 35f
        //FILL时strokeWidth值无意义
        paint.style = Paint.Style.FILL

        paint.textAlign = Paint.Align.LEFT
        paint.isUnderlineText = true
        paint.isStrikeThruText = true
        paint.isFakeBoldText = true
        paint.typeface = Typeface.SANS_SERIF
        //字体倾斜，负数向右倾斜
        paint.textSkewX = -0.25F
        paint.textScaleX = 2f
    }

    private var text = "生成方式的区别在于，依据生成方向排版的文字！"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        paint.textAlign = Paint.Align.LEFT
        //LEFT:文字的左侧与x对齐,默认LEFT，CENTER：文字的中间与x对齐，RIGHT：文字的右侧与x对齐
        text = "textAlign-default"
        canvas.drawText(text, width/2f, 50f, paint)

        text = "textAlign-LEFT"
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(text, width/2f, 100f, paint)

        text = "textAlign-CENTER"
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(text, width/2f, 200f, paint)

        text = "textAlign-RIGHT"
        paint.textAlign = Paint.Align.RIGHT
        canvas.drawText(text, width/2f, 300f, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMea = MeasureSpec.makeMeasureSpec(400, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMea)
    }
}
