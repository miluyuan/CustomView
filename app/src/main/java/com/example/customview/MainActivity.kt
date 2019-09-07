package com.example.customview

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.telephony.TelephonyManager
import com.example.customview.demo.DemoActivity
import com.example.customview.layout_1.MeasureLayoutActivity
import com.example.customview.layout_2.FlowLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn201.setOnClickListener { startActivity(Intent(this, DemoActivity::class.java)) }

        btn101.setOnClickListener { startActivity(Intent(this, MeasureLayoutActivity::class.java)) }
        btn102.setOnClickListener { startActivity(Intent(this, FlowLayoutActivity::class.java)) }

        btn1.setOnClickListener { startActivity(Intent(this, DrawActivity::class.java)) }
        btn2.setOnClickListener { startActivity(Intent(this, AnimateActivity::class.java)) }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val deviceId = tm.deviceId
            println(deviceId)
        } else {
            requestPermissions(arrayOf(Manifest.permission.READ_PHONE_STATE), 22)
        }

    }
}
