package com.example.customview.demo.movablebutton

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.example.customview.util.DisplayUtil
import kotlin.math.abs

/**
 * @author wzw
 * @date 2019/12/3 17:10
 */
class MovableButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatButton(context, attrs, defStyleAttr) {

    var flag = true
    var xTemp = 0f
    var yTemp = 0f
    init {
        setOnClickListener {
            if (flag) {
                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        var xDelta = 0f
        var yDelta = 0f
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                xTemp = event.rawX
                yTemp = event.rawY
                flag = true

            }
            MotionEvent.ACTION_MOVE -> {
                xDelta = event.rawX - xTemp
                yDelta = event.rawY - yTemp
                val scale = 2

                Log.e("onTouchEvent", "$flag,xDelta=$xDelta,yDelta=$yDelta")
                if ((abs(xDelta) > scale || abs(yDelta) > scale)) {
                    translationX += xDelta
                    translationY += yDelta
                    xTemp = event.rawX
                    yTemp = event.rawY
                    flag = false
                }
            }
            MotionEvent.ACTION_UP -> {
                if (!flag) {
                    val screenWidthPixels = DisplayUtil.getScreenWidthPixels(context)
                    if (event.rawX < screenWidthPixels/2) {
                        translationX = 0f
                    } else {
                        translationX = (screenWidthPixels-width).toFloat()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }
}
