package com.sortalgorithms;

public class MergeSortAlgorithm {

    private static String[] aux;

    public static void sort(String[] a){
        aux = new String[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void merge(String[] a, int low, int mid, int high){
        int i = low, j = mid + 1;

        for(int k = low; k <= high; k++) aux[k] = a[k];

        for(int k = low; k <= high; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void sort(String[] a, int low, int high){
        if(high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static boolean less(String v, String w){
        return v.compareTo(w) < 0;
    }

    public static void printElement(String[] a){
        for(String i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        printElement(a);
        sort(a);
        printElement(a);
    }
}
