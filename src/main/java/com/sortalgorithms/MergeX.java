package com.sortalgorithms;

public class MergeX {
    private static final int CUTOFF = 7;

    private static void merge(String[] src, String[] dst, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        for(int k = 0; k < hi; k++){
            if(i > mid)                   dst[k] = src[j++];
            else if(j > hi)               dst[k] = src[i++];
            else if(less(src[j], src[i])) dst[k] = src[j++];
            else                          dst[k] = src[i++];
        }
    }

    private static void sort(String[] src, String[] dst, int lo, int hi){
        if(hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);

       /*if(!less(src[mid + 1], src[mid])) {
           for (int k = 0; k <= hi; k++) {
               dst[k] = src[k];
           }
       }*/
        // using System.arraycopy() is a bit faster than the above loop
        if(!less(src[mid + 1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }
    public static void sort(String[] a){
        String[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }
    private static void insertionSort(String[] a, int lo, int hi){
        for(int i = lo; i <= hi; i++){
            for(int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args){

        String[] a = {"T", "E", "G", "H", "B", "J", "L", "A", "W", "O"};
        sort(a);
        for(String s : a) System.out.print(s + " ");
    }
}
