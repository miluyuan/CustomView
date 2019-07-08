package com.example.customview.demo.landscapelinearlayout

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 *
 * @author wzw
 * @date 2019/7/8 15:39
 */
class LandscapeLinearLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

//        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
//        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
//        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
//        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
//
//
//        super.onMeasure(MeasureSpec.makeMeasureSpec(1700, heightMode),
//                MeasureSpec.makeMeasureSpec(widthSize, widthMode))
//        println("H=$measuredHeight")
//        println("W=$measuredWidth")
//        setMeasuredDimension(measuredHeight, measuredWidth)
//
//        pivotX = 0f
//        pivotY = 0f
//        translationY = measuredHeight.toFloat()
//        rotation = -90f
//        println(pivotX)
//        println(pivotY)
    }
}