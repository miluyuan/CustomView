package com.example.customview.animate_9

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animator_set.*

/**
 * 联合动画
 * https://blog.csdn.net/harvic880925/article/details/50759059
 */
class AnimatorSetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.customview.R.layout.activity_animator_set)

        btnStart1.setOnClickListener {
            doPlaySequentiallyAnimator()
        }

        btnStart2.setOnClickListener {
            doPlayTogetherAnimator()
        }
        btnStart3.setOnClickListener {
            doPlaySequentiallyAndTogether()
        }
    }

    private fun doPlaySequentiallyAndTogether() {
        //先顺序执行，再一起执行
        val tv1TranslateX = ObjectAnimator.ofFloat(tv1, "translationX", 0f, -300f)
        val tv1TranslateY = ObjectAnimator.ofFloat(tv1, "translationY", 0f, 300f, 0f)
        val tv2TranslateY = ObjectAnimator.ofFloat(tv2, "translationY", 0f, 400f, 0f)

        //实现方式一
//        val before = AnimatorSet()
//        before.playTogether(tv1TranslateY, tv2TranslateY)
//        val animatorSet = AnimatorSet()
//        animatorSet.play(tv1TranslateX).before(before)
        //实现方式二
        val animatorSet = AnimatorSet()
        animatorSet.play(tv1TranslateY).with(tv2TranslateY).after(tv1TranslateX)

        animatorSet.duration = 1000
        animatorSet.start()

        //注意与ObjectAnimator.ofPropertyValuesHolder()区分
        //ofPropertyValuesHolder用于对同一个控件做多种动画
        //animatorSet可统一对多个控件做多种动画
    }

    private fun doPlayTogetherAnimator() {
        val tv1TranslateY = ObjectAnimator.ofFloat(tv1, "translationY", 0f, 300f, 0f)
        tv1TranslateY.duration = 10000
        val tv2TranslateY = ObjectAnimator.ofFloat(tv2, "translationY", 0f, 400f, 0f)
        tv2TranslateY.duration = 5000
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(tv1TranslateY, tv2TranslateY)
        //属性在AnimatorSet中设置以后，会覆盖单个ObjectAnimator中的设置；
        //不设值时上面的时间有效，设值后以此值为准
//        animatorSet.duration = 1000
        animatorSet.start()
    }

    private fun doPlaySequentiallyAnimator() {
        val tv1BgAnimator = ObjectAnimator.ofInt(tv1, "BackgroundColor", -0xff01, -0x100, -0xff01)
        tv1BgAnimator.repeatCount = 10

        val tv1TranslateY = ObjectAnimator.ofFloat(tv1, "translationY", 0f, 300f, 0f)
        tv1TranslateY.repeatCount = 10
        tv1TranslateY.duration = 10000

        val tv2TranslateY = ObjectAnimator.ofFloat(tv2, "translationY", 0f, 400f, 0f)
        tv2TranslateY.repeatCount = 10
        tv2TranslateY.duration = 5000

        val animatorSet = AnimatorSet()
        //按顺序执行，如果前面的动画设置了无限循环，则后面的动画永远不会执行
        animatorSet.playSequentially(tv1BgAnimator, tv1TranslateY, tv2TranslateY)
        //指每个动画分别用时, 以这个时间为准：设置了这个时间后，上面各自设置的时间无效
        animatorSet.duration = 1000
        animatorSet.start()
    }
}
