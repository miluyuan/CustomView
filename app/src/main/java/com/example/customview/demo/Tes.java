package com.example.customview.demo;

import android.content.Context;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author wzw
 * @date 2019/6/17 10:43
 */
public class Tes extends View {
    RectF mRectF;
    public Tes(Context context) {
        this(context, null);
    }

    public Tes(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Tes(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        jusssss();
    }

    private void jusssss() {
        int x = 0xFF0000FF;
        int t = 0x000000FF;
        int i = 1;
        t = t | i;
        t = t << 9;
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRectF = new RectF(0f, 0f, 0f, 0f);

    }
}
