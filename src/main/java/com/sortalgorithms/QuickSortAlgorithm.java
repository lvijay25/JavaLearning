package com.sortalgorithms;

import java.util.*;

public class QuickSortAlgorithm {

    private static Random random;
    public static void sort(int[] a){
            shuffle(a);
            int N = a.length;
            sort(a, 0, N - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, 0, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    public static int partition(int[] a, int low, int high) {
        int i = low, j = high + 1;
        int v = a[low];
        while (true) {
            while (less(a[++i], v)) {
                if (i == high) break;
            }
            while (less(v, a[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

    public static void shuffle(int[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniformInt(n - i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int uniformInt(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt(n);
    }

    private static void validateNotNull(Object x) {
        if (x == null) {
            throw new IllegalArgumentException("argument must not be null");
        }
    }

    public static void exchange(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Integer v, Integer w){
        if(v == w) return false;
        return v.compareTo(w) > 0;
    }
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 8, 9, 7, 10, 1, 4, 12, 11, 15, 14, 13};
        sort(a);
        for (int j : a) System.out.print(j + " ");
    }
}
