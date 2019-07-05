package com.example.customview.animate_vpa

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateInterpolator
import android.widget.Toast
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_view_property_animator.*

/**
 * 用ViewPropertyAnimator view.animate()实现链式调用
 */
class ViewPropertyAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_property_animator)
        btnStart.setOnClickListener {
            //缺点是动画只能执行一次
            val viewPropertyAnimator = tv.animate()
            viewPropertyAnimator
                    .setDuration(3000)
                    .setInterpolator(AccelerateInterpolator())
                    .alpha(0.5f)
                    .rotation(360f)
                    .translationX(400f)
                    .translationY(400f)
        }

        tv.setOnClickListener { Toast.makeText(this, tv.text, Toast.LENGTH_SHORT).show()  }
    }
}
