package com.example.customview.draw_6

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_advance_path.*

class AdvancePathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advance_path)
        root.addView(BezierLine(this))
        root.addView(GestureLine(this))
        root.addView(GestureLineUseBezier(this))
        root.addView(WaveView(this))
    }
}
