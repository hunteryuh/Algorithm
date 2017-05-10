package com.example.ALG;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HAU on 3/9/2017.
 */
public class myAverageFromFile {
    private myAverageFromFile() { }

    /**
     * Reads in a sequence of real numbers from standard input and prints
     * out their average to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int count = 0;       // number input values
        double sum = 0.0;    // sum of input values

        // read data and compute statistics
        In in = new In(args[0]);
        double[] whitelist = in.readAllDoubles();
        count = whitelist.length;
        for (double d: whitelist ){
            sum += d;
        }
        double average = sum / count;

        // print results
        System.out.println("Average is " + average);
    }
}
