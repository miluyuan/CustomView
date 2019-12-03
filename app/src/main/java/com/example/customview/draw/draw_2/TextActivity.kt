package com.example.customview.draw.draw_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_draw1.*

class TextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        root.addView(DrawTextView(this))
    }
}
