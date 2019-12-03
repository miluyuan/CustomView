package com.example.customview.animate.animate_8

import android.animation.TypeEvaluator

class CharEvaluator : TypeEvaluator<Char> {
    override fun evaluate(fraction: Float, startValue: Char, endValue: Char): Char {
        val start = startValue.toInt()
        val end = endValue.toInt()

        val result = start + fraction * (end - start)
        return result.toChar()
    }
}
