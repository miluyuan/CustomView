package com.example.customview.draw.draw_5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_draw_text.*

class DrawTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_text)
        root.addView(TextBaseLineView(this))
        root.addView(FourLineView(this))
        root.addView(TextAreaView(this))
    }
}
