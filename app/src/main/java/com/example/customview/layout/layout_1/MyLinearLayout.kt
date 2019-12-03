package com.example.customview.layout.layout_1

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup

/**
 *
 * @author wzw
 * @date 2019/5/22 11:06
 */
class MyLinearLayout @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        ViewGroup(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        var width = 0
        var height = 0
        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)

            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            width = Math.max(childWidth, width)
            height += childHeight

            Log.e("====", "$childWidth : $childHeight")
        }

        setMeasuredDimension(if (measureWidthMode == MeasureSpec.EXACTLY) measureWidth else width,
                if (measureHeightMode == MeasureSpec.EXACTLY) measureHeight else height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var top = 0
        var left = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val lp = child.layoutParams as MarginLayoutParams
            val width = child.measuredWidth
            val height = child.measuredHeight
            left = lp.leftMargin
            top += lp.topMargin
            child.layout(left + lp.leftMargin, top, left + width + lp.leftMargin, top + height)
            top += (height + lp.bottomMargin)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}