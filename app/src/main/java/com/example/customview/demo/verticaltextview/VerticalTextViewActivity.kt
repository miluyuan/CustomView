package com.example.customview.demo.verticaltextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_vertical_text_view.*

class VerticalTextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_text_view)
        tvv.setText("支持多行，对字符支持好 对于数字和字母支持不好。无法显示多行竖直显示.")
    }
}
