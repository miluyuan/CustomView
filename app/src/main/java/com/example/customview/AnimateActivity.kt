package com.example.customview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.animate_1.XmlAnimationActivity
import com.example.customview.animate_10.AnimatorDemoActivity
import com.example.customview.animate_2.XmlInterpolatorActivity
import com.example.customview.animate_5_interpolator.CustomInterpolatorActivity
import com.example.customview.animate_6.ValueAnimator1Activity
import com.example.customview.animate_8.PropertyValuesHolderActivity
import com.example.customview.animate_9.AnimatorSetActivity
import com.example.customview.animate_vpa.ViewPropertyAnimatorActivity
import kotlinx.android.synthetic.main.activity_animate.*

class AnimateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate)

        btn301.setOnClickListener { startActivity(Intent(this, XmlAnimationActivity::class.java)) }
        btn302.setOnClickListener { startActivity(Intent(this, XmlInterpolatorActivity::class.java)) }
        btn305.setOnClickListener { startActivity(Intent(this, CustomInterpolatorActivity::class.java)) }
        btn306.setOnClickListener { startActivity(Intent(this, ValueAnimator1Activity::class.java)) }
        btn308.setOnClickListener { startActivity(Intent(this, PropertyValuesHolderActivity::class.java)) }
        btn309.setOnClickListener { startActivity(Intent(this, AnimatorSetActivity::class.java)) }
        btn310.setOnClickListener { startActivity(Intent(this, AnimatorDemoActivity::class.java)) }
        btn30X.setOnClickListener { startActivity(Intent(this, ViewPropertyAnimatorActivity::class.java)) }

    }
}
