package com.example.customview;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author wzw
 * @date 2019/5/23 16:35
 */
public class Test {
    public static void main(String[] arr) {
//        Point cen = new Point(0, 0);
//        System.out.println(Math.atan(1)*360/2/Math.PI);
//        System.out.println(Math.atan(-1)*360/2/Math.PI);


//        float angle = Angle(cen, new Point(-10, 10), new Point(10, 0));
//        System.out.println("angle=" + angle);
//        int degree = (int) (angle * 360 / (2 * Math.PI));
//        System.out.println("degree=" + degree);
//
//
//        System.out.println("=============");
//        float angle2 = Angle2(cen, new Point(-10, 10), new Point(10, 0));
//        System.out.println("angle=" + angle);
//        int degree2 = (int) (angle * 360 / (2 * Math.PI));
//        System.out.println("degree=" + degree);
//        double number = 12345678.5555555555;
//        DecimalFormat f = new DecimalFormat("#.###");
//        f.setMaximumFractionDigits(2);
//        System.out.println(f.format(number));

//        doubleFormat();
        System.out.println(Integer.toBinaryString(3));

    }
//https://blog.csdn.net/qq_36502826/article/details/86673906
    //https://blog.csdn.net/bailu666666/article/details/79829902
    public static String double2Str(Double d) {
        if (d == null) {
            return "";
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setRoundingMode(RoundingMode.FLOOR);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
//        nf.setMaximumIntegerDigits(2);
        nf.setMinimumIntegerDigits(20);
        return nf.format(d);
    }

    private static void doubleFormat() {
        double number = 12345678.545245;
        //显示两位小数，会四舍五入
        String format = new DecimalFormat("4.44").format(number);
        String format4 = new DecimalFormat("0.00").format(number);
        //保留两位小数，两位小数都为0则不显示小数，会四舍五入
        String format2 = new DecimalFormat("#.##").format(number);
        //取整，会四舍五入
        String format3 = new DecimalFormat("#").format(number);
        System.out.println(number);
        System.out.println(format);
        System.out.println(format2);
        System.out.println(format3);
        System.out.println(format4);
    }

    private static int add(int i) {
        if (i == 1) {
            return i;
        }
        return i + add(i - 1);
    }

    public static float Angle(Point cen, Point first, Point second) {
        float dx1, dx2, dy1, dy2;
        float angle;

        dx1 = first.x - cen.x;
        dy1 = first.y - cen.y;

        dx2 = second.x - cen.x;
        dy2 = second.y - cen.y;

        float c = (float) Math.sqrt(dx1 * dx1 + dy1 * dy1) * (float) Math.sqrt(dx2 * dx2 + dy2 * dy2);

        if (c == 0) return -1;

        float a = (dx1 * dx2 + dy1 * dy2) / c;
        System.out.println("c=" + c);
        System.out.println("a=" + a);
        angle = (float) Math.acos(a);

        return angle;
    }

    public static float Angle2(Point cen, Point first, Point second) {
        float dx1, dx2, dy1, dy2;
        float angle;

        dx1 = first.x - cen.x;
        dy1 = first.y - cen.y;

        dx2 = second.x - cen.x;
        dy2 = second.y - cen.y;

        double v = Math.atan(dy1 / dx1) - Math.atan(dy2 / dx2);
        System.out.println("v=" + v);
        return (float) v;
    }


}
