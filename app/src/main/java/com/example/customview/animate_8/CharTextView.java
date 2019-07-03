package com.example.customview.animate_8;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * 此处不能本类改成kotlin，否则会报如下错误日志：
 * W/PropertyValuesHolder: Method setCharText() with type class java.lang.Character
 * not found on target class class com.example.customview.animate_6.MyTextView
 *
 * @author wzw
 * @date 2019/7/2 16:47
 */
public class CharTextView extends AppCompatTextView {
    public CharTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character c) {
        setText(String.valueOf(c));
    }
}
