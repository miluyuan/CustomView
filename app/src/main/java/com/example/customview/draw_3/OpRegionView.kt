package com.example.customview.draw_3

import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/23 11:02
 */
class OpRegionView(context: Context) : View(context) {
    private val paint by lazy {
        val p = Paint()
        p.isAntiAlias = true
        p.strokeWidth = 4f
        p.style = Paint.Style.STROKE
        p.color = Color.RED
        p
    }
    private val textPaint by lazy {
        val p = Paint()
        p.isAntiAlias = true
        p.style = Paint.Style.FILL
        p.color = Color.RED
        p.textSize = 28f
        p
    }

    private val opPaint by lazy {
        val p = Paint()
        p.isAntiAlias = true
        p.color = Color.BLUE
        p
    }

    private var rect1 = Rect(100, 110, 400, 210)//横
    private var rect2 = Rect(200, 10, 300, 310)//竖
    private var region1 = Region(rect1)
    private var region2 = Region(rect2)

    private var rect3 = Rect(100 + 400, 100, 400 + 400, 200)
    private var rect4 = Rect(200 + 400, 0, 300 + 400, 300)
    private var region3 = Region(rect3)
    private var region4 = Region(rect4)

    private var rect5 = Rect(100, 100 + 450, 400, 200 + 450)
    private var rect6 = Rect(200, 0 + 450, 300, 300 + 450)
    private var region5 = Region(rect5)
    private var region6 = Region(rect6)

    private var rect7 = Rect(100 + 400, 100 + 450, 400 + 400, 200 + 450)
    private var rect8 = Rect(200 + 400, 0 + 450, 300 + 400, 300 + 450)
    private var region7 = Region(rect7)
    private var region8 = Region(rect8)

    private var rect9 = Rect(100, 100 + 450 * 2, 400, 200 + 450 * 2)
    private var rect10 = Rect(200, 0 + 450 * 2, 300, 300 + 450 * 2)
    private var region9 = Region(rect9)
    private var region10 = Region(rect10)

    private var rect11 = Rect(100 + 400, 100 + 450 * 2, 400 + 400, 200 + 450 * 2)
    private var rect12 = Rect(200 + 400, 0 + 450 * 2, 300 + 400, 300 + 450 * 2)
    private var region11 = Region(rect11)
    private var region12 = Region(rect12)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //补集
        canvas?.drawRect(rect1, paint)
        canvas?.drawRect(rect2, paint)
        region1.op(region2, Region.Op.DIFFERENCE)
        drawRegion(canvas, region1, opPaint)
        canvas?.drawText("Region.Op.DIFFERENCE 补集", 100f, 350f, textPaint)

        //交集
        canvas?.drawRect(rect3, paint)
        canvas?.drawRect(rect4, paint)
        region3.op(region4, Region.Op.REVERSE_DIFFERENCE)
        drawRegion(canvas, region3, opPaint)
        canvas?.drawText("Region.Op.REVERSE_DIFFERENCE 反转补集", 100f + 400, 350f, textPaint)

        //替换
        canvas?.drawRect(rect5, paint)
        canvas?.drawRect(rect6, paint)
        region5.op(region6, Region.Op.REPLACE)
        drawRegion(canvas, region5, opPaint)
        canvas?.drawText("Region.Op.REPLACE 替换", 100f, 350f + 450, textPaint)

        //反转补集
        canvas?.drawRect(rect7, paint)
        canvas?.drawRect(rect8, paint)
        region7.op(region8, Region.Op.INTERSECT)
        drawRegion(canvas, region7, opPaint)
        canvas?.drawText("Region.Op.INTERSECT 交集", 100f + 400, 350f + 450, textPaint)

        //并集
        canvas?.drawRect(rect9, paint)
        canvas?.drawRect(rect10, paint)
        region9.op(region10, Region.Op.UNION)
        drawRegion(canvas, region9, opPaint)
        canvas?.drawText("Region.Op.UNION 并集", 100f, 350f + 450 * 2, textPaint)

        //异并集
        canvas?.drawRect(rect11, paint)
        canvas?.drawRect(rect12, paint)
        region11.op(region12, Region.Op.XOR)
        drawRegion(canvas, region11, opPaint)
        canvas?.drawText("Region.Op.XOR 异并集", 100f + 400, 350f + 450 * 2, textPaint)

        Log.e("===", "" + region1.isEmpty)
        Log.e("===", "" + region1.isRect)
        Log.e("===", "" + region1.isComplex)
    }

    private fun drawRegion(canvas: Canvas?, region: Region, paint: Paint) {
        val iterator = RegionIterator(region)
        val rect = Rect()
        while (iterator.next(rect)) {
            canvas?.drawRect(rect, paint)
        }
    }
//
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val heightMea = MeasureSpec.makeMeasureSpec(320, MeasureSpec.EXACTLY)
//        super.onMeasure(widthMeasureSpec, heightMea)
//    }

}