package com.example.ALG;

/**
 * Created by HAU on 3/26/2017.
 */
public class myShuffle {
    public static void shuffle(Object[] a){
        int n = a.length;
        for (int i = 0; i<n; i++){
            int r = (int) (Math.random()*(i+1));   // swap the current i and any one between 0 and i
            exch(a,i,r);
        }
    }

    private static void exch(Object[] a, int i, int r) {
        Object swap = a[i];
        a[i] = a[r];
        a[r] = swap;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        myShuffle.shuffle(a);
        for (int i = 0; i<a.length;i++){
            StdOut.println(a[i]);
        }
    }
}
