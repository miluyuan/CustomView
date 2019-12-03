package com.example.customview.layout.layout_2

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 *
 * @author wzw
 * @date 2019/6/11 9:53
 */
class FlowLayout(context: Context, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        var width = 0
        var height = 0
        var lineWidth = 0
        var lineHeight = 0

        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            val lp = child.layoutParams as MarginLayoutParams
            val childWith = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            if (lineWidth + childWith > measureWidth) {
                //需要换行
                height += lineHeight
                width = Math.max(width, childWith)

                lineWidth = childWith
                lineHeight = childHeight
            } else {
                lineHeight = Math.max(lineHeight, childHeight)
                lineWidth += childWith
            }

            if (i == count - 1) {
                height += lineHeight
                width = Math.max(width, childWith)
            }
        }

        setMeasuredDimension(if (measureWidthMode == MeasureSpec.EXACTLY) measureWidth else width,
                if (measureHeightMode == MeasureSpec.EXACTLY) measureHeight else height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        var lineWidth = 0
        var lineHeight = 0
        var left = 0
        var top = 0
        for (i in 0 until count) {
            val child = getChildAt(i)
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            if (childWidth + lineWidth > measuredWidth) {
                left = 0
                top += lineHeight

                lineHeight = childHeight
                lineWidth = childWidth
            } else {
                lineHeight = Math.max(lineHeight, childHeight)
                lineWidth += childWidth
            }
            val lc = left + lp.leftMargin
            val tc = top + lp.topMargin
            val rc = lc + child.measuredWidth
            val bc = tc + child.measuredHeight
            child.layout(lc, tc, rc, bc)

            left += childWidth
        }
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }
}