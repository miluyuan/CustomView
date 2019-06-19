package com.example.customview.draw_3

import android.content.Context
import android.graphics.*
import android.view.View

/**
 *
 * @author wzw
 * @date 2019/5/15 17:38
 */
class RegionView(context: Context) : View(context) {
    val paint = Paint()
    private val region: Region

    private val path: Path
        get() {
            val path = Path()
            val rect = RectF(20f, 20f, 200f, 500f)
            path.addOval(rect, Path.Direction.CCW)
            return path
        }

    init {
//        paint.isAntiAlias=true
        region = Region(20, 20, 200, 500)

        region.setPath(path, region)
        paint.color = Color.RED
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth= 2f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawRegion(canvas, region, paint)
    }

    private fun drawRegion(canvas: Canvas?, region: Region, paint: Paint) {
        val regionIterator = RegionIterator(region)
        val rect = Rect()
        while (regionIterator.next(rect)) {
            canvas?.drawRect(rect, paint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val heightMea = MeasureSpec.makeMeasureSpec(540, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMea)
    }
}