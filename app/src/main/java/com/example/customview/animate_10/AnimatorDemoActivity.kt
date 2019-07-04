package com.example.customview.animate_10

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.customview.R
import kotlinx.android.synthetic.main.activity_animator_demo.*
import kotlin.math.cos
import kotlin.math.sin

class AnimatorDemoActivity : AppCompatActivity() {

    private val list = ArrayList<ObjectAnimator>(8)
    val set = AnimatorSet()
    //夹角弧度值
    private var angle = Math.toRadians(22.5).toFloat()
    //移动距离
    private var radius = 1080f / 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_demo)
        tvMaster.setOnClickListener {
            list.clear()
            addTranslations()
            addScales()
            addAlphas()


            set.duration = 1000
            set.removeAllListeners()
            set.playTogether(list as Collection<Animator>?)
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
            set.start()
        }
        initListener()
    }

    private fun initListener() {
        tvEast.setOnClickListener { Toast.makeText(this, tvEast.text, Toast.LENGTH_SHORT).show() }
        tvWest.setOnClickListener { Toast.makeText(this, tvWest.text, Toast.LENGTH_SHORT).show() }
        tvCenter.setOnClickListener { Toast.makeText(this, tvCenter.text, Toast.LENGTH_SHORT).show() }
        tvSouth.setOnClickListener { Toast.makeText(this, tvSouth.text, Toast.LENGTH_SHORT).show() }
        tvNorth.setOnClickListener { Toast.makeText(this, tvNorth.text, Toast.LENGTH_SHORT).show() }

        btnCancel.setOnClickListener { set.cancel() }
        btnStart.setOnClickListener { set.reverse() }
    }

    private fun getTranslationX(tv: View, angle: Float): ObjectAnimator {
        return ObjectAnimator.ofFloat(tv, "translationX", 0f, -radius * cos(angle))
    }

    private fun getTranslationY(tv: View, angle: Float): ObjectAnimator {
        return ObjectAnimator.ofFloat(tv, "translationY", 0f, -radius * sin(angle))
    }

    private fun addAlphas() {
        list.add(ObjectAnimator.ofFloat(tvEast, "alpha", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvWest, "alpha", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvCenter, "alpha", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvSouth, "alpha", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvNorth, "alpha", 0f, 1f))
    }

    private fun addScales() {
        list.add(ObjectAnimator.ofFloat(tvEast, "scaleX", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvEast, "scaleY", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvWest, "scaleX", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvWest, "scaleY", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvCenter, "scaleX", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvCenter, "scaleY", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvSouth, "scaleX", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvSouth, "scaleY", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvNorth, "scaleX", 0f, 1f))
        list.add(ObjectAnimator.ofFloat(tvNorth, "scaleY", 0f, 1f))
    }

    private fun addTranslations() {

        val eastTrasnX = getTranslationX(tvEast, 0f)
//        eastTrasnX.repeatCount = 1
//        eastTrasnX.repeatMode = ValueAnimator.REVERSE
        val westTrasnX = getTranslationX(tvWest, angle)
        val westTrasnY = getTranslationY(tvWest, angle)
        val centerTrasnX = getTranslationX(tvCenter, angle * 2)
        val centerTrasnY = getTranslationY(tvCenter, angle * 2)

        val southTrasnX = getTranslationX(tvSouth, angle * 3)
        val southTrasnY = getTranslationY(tvSouth, angle * 3)
        val northTrasnX = getTranslationX(tvNorth, angle * 4)
        val northTrasnY = getTranslationY(tvNorth, angle * 4)
        list.add(eastTrasnX)
        list.add(westTrasnX)
        list.add(westTrasnY)
        list.add(centerTrasnX)
        list.add(centerTrasnY)
        list.add(southTrasnX)
        list.add(southTrasnY)
        list.add(northTrasnX)
        list.add(northTrasnY)
    }

}
