package com.example.customview.animate_8

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateInterpolator
import kotlinx.android.synthetic.main.activity_property_values_holder.*



class PropertyValuesHolderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.customview.R.layout.activity_property_values_holder)

        val charHolder = PropertyValuesHolder.ofObject("CharText",
                CharEvaluator(), 'A', 'Z')
        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv, charHolder)
        objectAnimator.duration = 6000
        objectAnimator.interpolator = AccelerateInterpolator()

        btnStart.setOnClickListener {
//            objectAnimator.start()
            doOfObjectAnim()
        }
    }

    private fun doOfObjectAnim() {
        val charHolder = PropertyValuesHolder.ofObject("CharText", CharEvaluator(), 'A', 'Z')
        val animator = ObjectAnimator.ofPropertyValuesHolder(tv, charHolder)
        animator.duration = 3000
        animator.interpolator = AccelerateInterpolator()
        animator.start()
    }
}
