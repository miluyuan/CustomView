package com.example.customview.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import com.example.customview.demo.bagua.BaguaActivity
import com.example.customview.demo.landscapelinearlayout.LandscapeLinearLayoutActivity
import com.example.customview.demo.pendulum.PendulumActivity
import com.example.customview.demo.radar.RadarActivity
import com.example.customview.demo.verticaltextview.VerticalTextViewActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn1.setOnClickListener { startActivity(Intent(this, RadarActivity::class.java)) }
        btn2.setOnClickListener { startActivity(Intent(this, BaguaActivity::class.java)) }
        btn3.setOnClickListener { startActivity(Intent(this, PendulumActivity::class.java)) }
        btn4.setOnClickListener { startActivity(Intent(this, VerticalTextViewActivity::class.java)) }
        btn5.setOnClickListener { startActivity(Intent(this, LandscapeLinearLayoutActivity::class.java)) }
    }
}
