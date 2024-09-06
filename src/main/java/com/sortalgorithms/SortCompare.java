package com.sortalgorithms;

public class SortCompare {
    public static double time(String alg, Comparable[] a){
        StopWatch timer = new StopWatch();
        if(alg.equals("Insertion")) InsertionSortAlgorithm.sort(a);
        else if (alg.equals("Selection"))  SelectionSortAlgorithm.sort(a);
        else throw new IllegalArgumentException("Invalid algorithm: " + alg);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int trails){
        double total = 0.0;
        Double[] a = new Double[n];
        for(int t = 0; t < trails; t++){
            for(int i = 0; i < n; i++)
                a[i] = StdRandom.uniformDouble(0.0, 1.0);
            total += time(alg, a);
        }
        return total;
    }
    public static double timeSortedInput(String alg, int n, int trails){
        double total = 0.0;
        Double[] a = new Double[n];
        for(int t = 0; t < trails; t++){
            for(int i = 0; i < n; i++)
                a[i] = 1.0 * i;
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args){
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int trails = Integer.parseInt(args[3]);
        double time1, time2;
        if(args.length == 5 && args[4].equals("sorted")){
            time1 = timeSortedInput(alg1, n, trails);
            time2 = timeSortedInput(alg2, n, trails);
        }else{
            time1 = timeRandomInput(alg1, n, trails);   // Total for alg1.
            time2 = timeRandomInput(alg2, n, trails);   // Total for alg2.
        }
        System.out.printf("For %d random Doubles\n    %s is", n, alg1);
        System.out.printf(" %.1f times faster than %s\n", time2/time1, alg2);
    }
}
