package com.example.customview.animate.animate_5_interpolator

import android.animation.TypeEvaluator

/**
 *
 * @author wzw
 * @date 2019/7/1 16:36
 */
class ReverseEvaluator :TypeEvaluator<Int> {
    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        //反方向运动
        return (endValue - fraction * (endValue - startValue)).toInt()
    }
}