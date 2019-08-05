package com.example.customview.demo.iconview

import android.annotation.TargetApi
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.example.customview.R

/**
 *
 * @author wzw
 * @date 2019/8/5 11:08
 */
class IconView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var mTextSize = 0f
    lateinit var paint: Paint
    lateinit var mBitmap: Bitmap
    private val mStr = "JohnSnow"

    private enum class Ratio {
        WIDTH, HEIGHT
    }

    init {
        calArgs()
        init()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(getMeasureSize(widthMeasureSpec, Ratio.WIDTH),
                getMeasureSize(heightMeasureSpec, Ratio.HEIGHT))
    }

    private fun getMeasureSize(measureSpec: Int, ratio: Ratio): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)

        var result = 0
        if (MeasureSpec.EXACTLY == mode) {
            result = size
        } else {
            if (Ratio.WIDTH == ratio) {
                val textW = paint.measureText(mStr)
                result = (Math.max(textW, mBitmap.width.toFloat()) + paddingLeft + paddingRight).toInt()
            } else if (Ratio.HEIGHT == ratio) {
                result = ((paint.descent() - paint.ascent()) * 2 + mBitmap.height + paddingTop + paddingBottom).toInt()
            }

            if (MeasureSpec.AT_MOST == mode) {
                result = Math.min(size, result)
            }
        }

        return result
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.RED)
        canvas.drawBitmap(mBitmap, width / 2f - mBitmap.width / 2f, height / 2f - mBitmap.height / 2f, null)
        canvas.drawText(mStr, width / 2f, mBitmap.height + height / 2f - mBitmap.height / 2f - paint.ascent(), paint)
    }

    private fun init() {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher)

        paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG or Paint.LINEAR_TEXT_FLAG)
        paint.color = Color.LTGRAY
        paint.textSize = mTextSize
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT_BOLD
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun calArgs() {
        val displayMetrics = context.resources.displayMetrics
        val screenW = displayMetrics.widthPixels

        mTextSize = screenW * 0.1f
    }
}