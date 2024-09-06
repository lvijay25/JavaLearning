package com.searchalgorithms;

public class BinarySearchAlgorithm {
    public static void insertionSort(int[] a){
        int n = a.length;
        for(int i = 1; i < n; i++){
            int j = i;
            while(j > 0 && a[j] < a[j - 1]){
                int t = a[j];
                a[j] = a[j - 1];
                a[j - 1] = t;
                j--;
            }
        }
    }
    public static int binarySearch(int[] a, int k){
        int low = 0;
        int high = a.length;
        int mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(a[mid] < k){
                low = mid + 1;
            }else if(a[mid] == k){
                return mid;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ax = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] u = {10, 2, 3, 5, 7, 6, 8, 9, 1};
        insertionSort(u);
        for (int j : u) {
            System.out.print(j + " ");
        }
        System.out.println("\nIndex Of an Element " + binarySearch(u, 9));

        // Sorting element with Loops

        int a = 33;
        int b = 22;
        int c = 18;
        int d = 43;

        if(b < a){int t = b; b = a; a = t;}
        if(c < a){int t = c; c = b; b = t;}
        if(b < a){int t = a; a = b; b = t;}

        System.out.println(a + " " + b + " " + c + " " + b);
    }
}
