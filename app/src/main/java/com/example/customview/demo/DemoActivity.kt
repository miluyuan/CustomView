package com.example.customview.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import com.example.customview.demo.bagua.BaguaActivity
import com.example.customview.demo.radar.RadarActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn1.setOnClickListener { startActivity(Intent(this, RadarActivity::class.java)) }
        btn2.setOnClickListener { startActivity(Intent(this, BaguaActivity::class.java)) }
    }
}
