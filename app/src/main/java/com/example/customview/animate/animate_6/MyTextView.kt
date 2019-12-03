package com.example.customview.animate.animate_6

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 *
 * @author wzw
 * @date 2019/7/2 16:11
 */
class MyTextView(context: Context, attrs: AttributeSet) : TextView(context, attrs) {

    fun setCharText(c: Char) {
        text = c.toString()
    }
}