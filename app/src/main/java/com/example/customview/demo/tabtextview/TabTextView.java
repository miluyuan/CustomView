package com.example.customview.demo.tabtextview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @author wzw
 * @date 2019/9/6 19:03
 */
public class TabTextView extends AppCompatTextView {

    private Paint mPaint;
    private Path mPath;
    int triangleWidth = 70;
    int triangleHeight = 50;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int h = getMeasuredHeight();
        int w = getMeasuredWidth();

        mPath.moveTo(w / 2f - triangleWidth / 2f, h);
        mPath.lineTo(w / 2f + triangleWidth / 2f, h);
        mPath.lineTo(w / 2f, h - triangleHeight);
        mPath.close();
        canvas.drawPath(mPath, mPaint);
        super.onDraw(canvas);
    }
}
