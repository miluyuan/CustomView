package com.example.customview.animate.animate_6

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateInterpolator
import com.example.customview.animate.animate_8.CharEvaluator
import kotlinx.android.synthetic.main.activity_value_animator1.*


class ValueAnimator1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.customview.R.layout.activity_value_animator1)
        val animator = ValueAnimator.ofObject(CharEvaluator(), 'A', 'Z')
        animator.addUpdateListener { animation ->
            val text = animation.animatedValue as Char
            tv.setCharText(text)
        }
        animator.duration = 10000
        animator.interpolator = AccelerateInterpolator()

        btnStart.setOnClickListener {
            animator.start()
        }

    }


}
