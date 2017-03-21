package com.example.ALG;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Created by HAU on 3/10/2017.
 */
public class myThreeSumFast {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time is " + timer.elapsedTime());
        StdOut.println(count);
    }
    private static boolean containDup(int[] a){
        //Arrays.sort(a);
        for (int i = 1; i < a.length; i++){
            if (a[i]==a[i-1]){
                return true;
            }
        }
        return false;
    }

    public static int count(int[] t){
        int n = t.length;
        Arrays.sort(t);
        // return -1;
        if (containDup(t)) {
            throw new IllegalArgumentException("this array contains duplicates");
        }
        int total = 0;
        //Arrays.sort
        for ( int i = 0; i < n; i++){
            for (int j = i+1 ; j<n; j++){
                int k = Arrays.binarySearch(t,-t[i]-t[j]);
                if (k>j) total++;

            }
        }
        return total;
    }
}
