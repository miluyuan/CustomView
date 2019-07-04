package com.example.customview.animate_10

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_animator_demo.*
import kotlin.math.cos
import kotlin.math.sin

class AnimatorDemoActivity : AppCompatActivity() {

    private val list = ArrayList<ObjectAnimator>(8)
    private val viewList = ArrayList<View>(8)
    private val set = AnimatorSet()
    //夹角弧度值
    private var angle = Math.toRadians(22.5).toFloat()
    //移动距离
    private var radius = 1080f / 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_demo)
        viewList.add(tvEast)
        viewList.add(tvWest)
        viewList.add(tvCenter)
        viewList.add(tvSouth)
        viewList.add(tvNorth)
        tvMaster.setOnClickListener {
            list.clear()
            addTranslations()
            addScales()
            addAlphas()

            set.duration = 1000
            set.playTogether(list as Collection<Animator>?)
            set.start()
        }
        initListener()
    }

    private fun initListener() {
        for (view in viewList) {
            val v = view as TextView
            v.setOnClickListener { Toast.makeText(this, v.text, Toast.LENGTH_SHORT).show() }
        }

        //cancel()会回调AnimatorListener的cancel和end
        btnCancel.setOnClickListener { set.cancel() }
        //reverse不会回调AnimatorListener
        btnReverse.setOnClickListener { set.reverse() }
        btnStart.setOnClickListener { set.start() }
        btnPause.setOnClickListener { set.pause() }
        btnResume.setOnClickListener { set.resume() }

        set.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                println("repeat")
            }

            override fun onAnimationEnd(animation: Animator?) {
                println("end")
            }

            override fun onAnimationCancel(animation: Animator?) {
                println("cancel")
            }

            override fun onAnimationStart(animation: Animator?) {
                println("start")
            }
        })
    }

    private fun addAlphas() {
        for (view in viewList) {
            list.add(ObjectAnimator.ofFloat(view, "alpha", 0f, 1f))
        }
    }

    private fun addScales() {
        for (view in viewList) {
            list.add(ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f))
            list.add(ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f))
        }
    }

    private fun addTranslations() {
        for ((i, view) in viewList.withIndex()) {
            list.add(ObjectAnimator.ofFloat(view, "translationX", 0f, -radius * cos(angle * i)))
            list.add(ObjectAnimator.ofFloat(view, "translationY", 0f, -radius * sin(angle * i)))
        }
    }

}
