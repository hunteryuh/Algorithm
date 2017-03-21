package com.example.ALG;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HAU on 3/20/2017.
 */
public class myInsertion {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i< n;i++){
            for (int j = i; j>0; j--){
                if (a[j].compareTo(a[j-1]) < 0)
                    exch(a,j,j-1);
                else break;
            }
        }
        assert isSorted(a);

    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a,0,a.length-1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i<hi; i++){
            if (a[lo+1].compareTo(a[lo])<0) return false;
        }
        return true;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[j];
        a[j]= a[i];
        a[i]= swap;
    }
    public static void show(Comparable[] a){
        for (int i =0; i<a.length;i++){
            StdOut.println(a[i]);
        }
    }

}
