package com.example.customview.demo.pendulum

import android.animation.TimeInterpolator

class PendulumInterpolator(val l:Float, val angle:Float) : TimeInterpolator {

    override fun getInterpolation(input: Float): Float {
        return input
    }
}
