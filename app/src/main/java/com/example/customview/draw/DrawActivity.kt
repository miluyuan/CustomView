package com.example.customview.draw

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import com.example.customview.draw.draw_1.Draw1Activity
import com.example.customview.draw.draw_2.PathActivity
import com.example.customview.draw.draw_2.TextActivity
import com.example.customview.draw.draw_3.RegionActivity
import com.example.customview.draw.draw_4.CanvasOperateActivity
import com.example.customview.draw.draw_5.DrawTextActivity
import com.example.customview.draw.draw_6.AdvancePathActivity
import com.example.customview.draw.draw_7.PaintMethodsActivity
import kotlinx.android.synthetic.main.activity_draw.*

class DrawActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
        btn1.setOnClickListener { startActivity(Intent(this, Draw1Activity::class.java)) }
        btn2.setOnClickListener { startActivity(Intent(this, PathActivity::class.java)) }
        btn3.setOnClickListener { startActivity(Intent(this, TextActivity::class.java)) }
        btn4.setOnClickListener { startActivity(Intent(this, RegionActivity::class.java)) }
        btn5.setOnClickListener { startActivity(Intent(this, CanvasOperateActivity::class.java)) }
        btn6.setOnClickListener { startActivity(Intent(this, DrawTextActivity::class.java)) }
        btn7.setOnClickListener { startActivity(Intent(this, AdvancePathActivity::class.java)) }
        btn8.setOnClickListener { startActivity(Intent(this, PaintMethodsActivity::class.java)) }
    }
}
