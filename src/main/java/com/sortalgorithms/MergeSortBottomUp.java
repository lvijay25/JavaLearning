package com.sortalgorithms;

public class MergeSortBottomUp {
    private static int[] aux;

    public static void sort(int[] a){
        int N = a.length;
        aux = new int[N];
        for(int size = 1; size < N; size=size+size)
            for(int low = 0; low < N - 1; low += size+size)
                merge(a, low, low+size - 1, Math.min(low+size+size - 1, N - 1));
    }

    public static void merge(int[] a, int low, int mid, int high){
        int i = low, j = mid + 1;
        for(int k = i; k <= high; k++) aux[k] = a[k];
        for(int k = i; k <= high; k++)
            if(i > mid)              a[k] = aux[j++];
            else if(j > high)        a[k] = aux[i++];
            else if(aux[j] < aux[i]) a[k] = aux[j++];
            else                     a[k] = aux[i++];
    }

    public static void printElement(int[] a){
        for (int j : a) System.out.print(j + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] a = {2, 3, 5, 4, 1, 6, 10, 8, 9, 11, 7, 12, 15, 14, 13};
        printElement(a);
        sort(a);
        printElement(a);
    }
}
