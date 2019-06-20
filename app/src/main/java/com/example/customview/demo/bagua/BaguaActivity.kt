package com.example.customview.demo.bagua

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_bagua.*

class BaguaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bagua)
        start.setOnClickListener { bagua.start() }
    }
}
