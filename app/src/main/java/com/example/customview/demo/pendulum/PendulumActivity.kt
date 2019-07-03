package com.example.customview.demo.pendulum

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_penddulum.*

class PendulumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penddulum)

        btnStart.setOnClickListener {
            pendulum.start()
        }
    }
}
