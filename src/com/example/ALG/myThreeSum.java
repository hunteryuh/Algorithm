package com.example.ALG;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HAU on 3/10/2017.
 */
public class myThreeSum {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println(timer.elapsedTime());
        StdOut.println(count);
    }

    public static int count(int[] t){
        int n = t.length;
        int total = 0;
        for ( int i = 0; i < n; i++){
            for (int j = i+1 ; j<n; j++){
                for (int m = j+1; m <n; m++){
                    if (t[i]+t[j]+t[m]==0){
                        total++;
                    }
                }
            }
        }
        return total;
    }
}
