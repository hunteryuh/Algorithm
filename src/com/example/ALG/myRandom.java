package com.example.ALG;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HAU on 3/9/2017.
 */
public class myRandom {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // how many numbers do we generate

        if (args.length ==1) {
            for (int i = 0; i < n; i++) {
                double randout = Math.random();
                StdOut.println(randout);
            }
        }
        if (args.length ==3){
            double hi = Double.parseDouble(args[2]);
            double lo = Double.parseDouble(args[1]);
            for (int i = 0; i<n ; i++){
                double randout = Math.random()*(hi-lo)+lo;
                StdOut.printf("%.2f\n",randout);
            }
        }
    }


}
