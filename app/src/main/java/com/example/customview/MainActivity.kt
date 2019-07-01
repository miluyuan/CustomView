package com.example.customview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.animate_1.XmlAnimationActivity
import com.example.customview.animate_2.XmlInterpolatorActivity
import com.example.customview.animate_5_interpolator.CustomInterpolatorActivity
import com.example.customview.demo.DemoActivity
import com.example.customview.layout_1.MeasureLayoutActivity
import com.example.customview.layout_2.FlowLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn301.setOnClickListener { startActivity(Intent(this, XmlAnimationActivity::class.java)) }
        btn302.setOnClickListener { startActivity(Intent(this, XmlInterpolatorActivity::class.java)) }
        btn305.setOnClickListener { startActivity(Intent(this, CustomInterpolatorActivity::class.java)) }

        btn201.setOnClickListener { startActivity(Intent(this, DemoActivity::class.java)) }

        btn101.setOnClickListener { startActivity(Intent(this, MeasureLayoutActivity::class.java)) }
        btn102.setOnClickListener { startActivity(Intent(this, FlowLayoutActivity::class.java)) }

        btn1.setOnClickListener { startActivity(Intent(this, DrawActivity::class.java)) }

    }
}
