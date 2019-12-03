package com.example.customview.util;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author 01375594
 */
public class DisplayUtil {

    public static final String TAG = "DisplayUtil";

    private DisplayUtil(){
        //empty
    }

    /**
     * dp 转 px
     * @param context   上下文
     * @param dp
     */
    public static int dp2px(Context context, float dp) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return (int) (dp * displayMetrics.density + 0.5F);
    }

    /**
     * px 转 dp
     * @param context   上下文
     * @param px
     */
    public static int px2dp(Context context, float px) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return (int) (px / displayMetrics.density + 0.5F);
    }

    /**
     * 获取显示度量
     * @param context   上下文
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) Objects.requireNonNull(context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE)))
                .getDefaultDisplay()
                .getMetrics(localDisplayMetrics);
        return localDisplayMetrics;
    }

    /**
     * 获取屏幕宽px
     * @param context   上下文
     */
    public static int getScreenWidthPixels(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕高px，包含状态栏，不包含导航栏
     * @param context   上下文
     */
    public static int getScreenHeightPixels(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.heightPixels;
    }

    /**
     * 获取屏幕原始尺寸高度，包含状态栏，包含导航栏
     * @param context   上下文
     */
    public static int getScreenHeightIncludeNavigationBarHeight(Context context) {
        int screenHeight = 0;
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            screenHeight = dm.heightPixels;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return screenHeight;
    }

    /**
     * 获取状态栏的高度
     * @param context   上下文
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = -1;
        int resourceId = context.getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    /**
     * 获取导航栏的高度
     * @param context   上下文
     */
    public static int getNavigationBarHeight(Context context) {
        int navigationBarHeight = -1;
        int resourceId = context.getResources()
                .getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return navigationBarHeight;
    }

    /**
     * 检查是否存在虚拟按键栏
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static boolean hasNavBar(Context context) {
        int resourceId = context.getResources()
                .getIdentifier("config_showNavigationBar", "bool", "android");
        if (resourceId != 0) {
            boolean hasNav = context.getResources().getBoolean(resourceId);
            // check override flag
            String sNavBarOverride = getNavBarOverride();
            if ("1".equals(sNavBarOverride)) {
                hasNav = false;
            } else if ("0".equals(sNavBarOverride)) {
                hasNav = true;
            }
            return hasNav;
        } else { // fallback
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
    }

    /**
     * 判断虚拟按键栏是否重写
     */
    @SuppressWarnings("unchecked")
    @SuppressLint("PrivateApi")
    private static String getNavBarOverride() {
        String sNavBarOverride = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                Class c = Class.forName("android.os.SystemProperties");
                Method m = c.getDeclaredMethod("get", String.class);
                m.setAccessible(true);
                sNavBarOverride = (String) m.invoke(null, "qemu.hw.mainkeys");
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
        return sNavBarOverride;
    }
}
