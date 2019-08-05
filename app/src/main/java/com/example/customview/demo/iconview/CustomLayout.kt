package com.example.customview.demo.iconview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class CustomLayout(context: Context, attrs: AttributeSet) : ViewGroup(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        /*
         * 如果有子元素
         */
        if (childCount > 0) {
            // 那么对子元素进行测量
            measureChildren(widthMeasureSpec, heightMeasureSpec)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        var mutiHeight = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.layout(0, mutiHeight, child.measuredWidth, child.measuredHeight + mutiHeight)
            mutiHeight += child.measuredHeight
        }
    }
}