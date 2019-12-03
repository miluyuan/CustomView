package com.example.customview.animate.animate_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_xml_animation.*

/**
 * xml动画R.anim.***
 */
class XmlAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_animation)

        val scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale)
        scale.setOnClickListener {
            tv.startAnimation(scaleAnim)
        }

        val alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha)
        alpha.setOnClickListener {
            tv.startAnimation(alphaAnim)
        }

        val rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate)
        rotate.setOnClickListener {
            tv.startAnimation(rotateAnim)
        }

        val translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate)
        translate.setOnClickListener {
            tv.startAnimation(translateAnim)
        }

        val setAnim = AnimationUtils.loadAnimation(this, R.anim.set_animate)
        set_animate.setOnClickListener {
            tv.startAnimation(setAnim)
        }
    }
}
