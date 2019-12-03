package com.example.customview.animate.animate_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_interpolator.*

/**
 * 在xml动画中设置插值器interpolator
 */
class XmlInterpolatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolator)
        val interpolatorAnim = AnimationUtils.loadAnimation(this, R.anim.interpolator)
        btn1.setOnClickListener {
            tv.startAnimation(interpolatorAnim)
        }
    }
}
