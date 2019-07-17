package com.example.customview.demo.bagua

import android.os.Build
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

    override fun onStop() {
        super.onStop()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            bagua.pause()
        } else {
            bagua.cancel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bagua.cancel()
    }

}
