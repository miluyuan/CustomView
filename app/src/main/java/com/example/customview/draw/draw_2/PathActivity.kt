package com.example.customview.draw.draw_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_draw1.*

class PathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path)

        root.addView(PathView(this, PathView.直线路径))
        root.addView(PathView(this, PathView.矩形路径))
        root.addView(PathView(this, PathView.圆角矩形路径))
        root.addView(PathView(this, PathView.圆形路径))
        root.addView(PathView(this, PathView.椭圆路径))
        root.addView(PathView(this, PathView.弧形路径))
        root.addView(PathView(this, PathView.线段轨迹))

    }
}
