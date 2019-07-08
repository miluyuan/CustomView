package com.example.customview.demo.landscapelinearlayout

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_landscape_linear_layout.*

class LandscapeLinearLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landscape_linear_layout)

        iv.setOnClickListener {
            root.pivotX = 0f
            root.pivotY = 0f
            ObjectAnimator.ofFloat(root, "rotation", 0f, -90f).apply {
                duration = 1000
                start()
            }

            ObjectAnimator.ofFloat(root, "translationY",
                    0f, root.measuredHeight.toFloat()).apply {
                duration = 3000
                start()
                root.invalidate()
            }

        }
    }
}
