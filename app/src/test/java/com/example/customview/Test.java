package com.example.customview;

/**
 * @author wzw
 * @date 2019/5/23 16:35
 */
public class Test {
    public static void main(String[] arr) {
        System.out.println(("main: " + 2%2));
        System.out.println(("main: " + 1.0%2));
        System.out.println(("main: " + 2.555%2));
        System.out.println(("main: " + 2.0%2));
        System.out.println(("main: " + 360/2/60));
    }

    private static int add(int i) {
        if (i == 1) {
            return i;
        }
        return i + add(i - 1);
    }
}
