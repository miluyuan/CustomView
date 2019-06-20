package com.example.customview;

/**
 * @author wzw
 * @date 2019/5/23 16:35
 */
public class Test {
    public static void main(String[] arr) {
//        Point cen = new Point(0, 0);
        System.out.println(Math.atan(1)*360/2/Math.PI);
        System.out.println(Math.atan(-1)*360/2/Math.PI);


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
