package com.example.customview.animate_5_interpolator

import android.animation.TimeInterpolator

/**
 * 重力加速度
 * Gravity acceleration
 *
 * @author wzw
 * @date 2019/7/1 15:11
 */
class GravityAccelerationInterpolator : TimeInterpolator {
    override fun getInterpolation(input: Float): Float {
        //l = gt²/2
        val g = 10f
        val l = g / 2

        return (g * input * input / 2) / l
    }
}
