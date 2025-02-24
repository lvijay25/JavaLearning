package com.java.corejava;


public class PassByReferenceVsPassByValue {
    /**
     * @param a
     * @param b
     * Pass By Reference works on Objects, Array is an Object...
     */
    public static void modifyArrayObject(int[] a, int[] b){
        a[0] = 10;
        b[0] = 20;
    }

    public static void modifyPrimitiveType(int a, int b){
        a = 10;
        b = 20;
    }

    public static void main(String... args){
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        System.out.println(a[0]);
        System.out.println(b[0]);

        modifyArrayObject(a, b);

        System.out.println(a[0]);
        System.out.println(b[0]);

        int x = 1;
        int y = 2;

        System.out.println("X: " + x);
        System.out.println("Y: " + y);

        modifyPrimitiveType(x, y);

        System.out.println("After Modify X: " + x);
        System.out.println("After Modify Y: " + y);

    }
}
