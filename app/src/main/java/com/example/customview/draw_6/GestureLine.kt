package com.example.customview.draw_6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View

/**
 * 手指轨迹
 * @author wzw
 * @date 2019/5/29 15:24
 */
class GestureLine(context: Context) : View(context) {
    private val paint = Paint()
    private val path = Path()
    var with = 0f

    init {
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null && event.x < with && event.y < with) {
            reset()
            return super.onTouchEvent(event)
        }
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(event.x, event.y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(event.x, event.y)
                postInvalidate()
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.LTGRAY)
        canvas?.drawPath(path, paint)

        paint.textSize = 20f
        with = paint.measureText("重置")
        canvas?.drawText("重置", 0f, 20f, paint)
    }

    fun reset() {
        path.reset()
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val h = MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY)
        setMeasuredDimension(widthMeasureSpec, h)
    }
}