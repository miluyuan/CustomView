package com.example.customview.draw_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_draw1.*

class Draw1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw1)
        root.addView(CircleView(this))
        root.addView(LineView(this))
        root.addView(LinesView(this))
        root.addView(PointsView(this))
        root.addView(RectView(this))
    }

}
