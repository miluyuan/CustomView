package com.example.customview.animate_5_interpolator

import android.animation.ArgbEvaluator
import android.animation.IntEvaluator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.LinearInterpolator
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_custom_interpolator.*

/**
 * 自定义Interpolator和Evaluator
 */
class CustomInterpolatorActivity : AppCompatActivity() {
    var top: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_interpolator)


        val animator = ValueAnimator.ofInt(0, 1800).apply {
            //匀加速运动
            interpolator = GravityAccelerationInterpolator()

            duration = 1 * 1000
        }

        animator.addUpdateListener {
            if (top == -1) {
                top = tv.top
            }
            val value = it.animatedValue as Int
            tv.layout(tv.left, top + value, tv.right, top + value + tv.height)
            println(value)
        }

        btnStart.setOnClickListener {
            //默认
            animator.setEvaluator(IntEvaluator())
            animator.start()
        }
        btnCancel.setOnClickListener {
            animator.cancel()
        }

        btnReverse.setOnClickListener {
            //倒序运动
            animator.setEvaluator(ReverseEvaluator())
            animator.start()
        }

        btnColorAnim.setOnClickListener { colorAnim() }
    }

    private fun colorAnim() {
        val animator = ValueAnimator.ofInt(0xffff0000.toInt(),0xff00ff00.toInt() , 0xff0000ff.toInt(),0xffff0000.toInt()).apply {
            interpolator = LinearInterpolator()
            duration = 5 * 1000
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
            //颜色渐变
            setEvaluator(ArgbEvaluator())
        }
        animator.addUpdateListener {
            val value = it.animatedValue as Int
            tvBg.setBackgroundColor(value)
            tv.text = value.toString()
            println(value)
        }
        animator.start()
    }

}
