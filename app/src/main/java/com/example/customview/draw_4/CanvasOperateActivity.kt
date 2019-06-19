package com.example.customview.draw_4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_canvas_operate.*

/**
 * 对画布的一些操作
 */
class CanvasOperateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_operate)
        root.addView(TranslateView(this))
        root.addView(RotateView(this))
        root.addView(ScaleView(this))
        root.addView(SkewView(this))
    }
}
