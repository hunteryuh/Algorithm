package com.example.ALG;

import edu.princeton.cs.algs4.*;

/**
 * Created by HAU on 3/22/2017.
 */
public class myMergeBU {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sortBU(a);
        show(a);
    }
    public static void show(Comparable[] a){
        for (int i = 0; i<a.length;i++){
            StdOut.println(a[i]);
        }
    }
    public static void sortBU(Comparable[] a){

        int n = a.length;
        Comparable[] a2 = new Comparable[n];
        for(int size=1; size< n;size= size * 2){
            for (int lo = 0; lo< n-size; lo = lo + size *2){
                merge(a,a2,lo,lo+size-1,Math.min(n-1,lo+size*2-1));
            }
        }
    }
    public static void merge(Comparable[] a, Comparable[] a2, int lo, int mid, int hi){

        for (int i=lo;i<=hi;i++) a2[i]=a[i];
        int i = lo;
        int j = mid +1;
        for (int k = lo; k<=hi ;k++){
            if ( j> hi) a[k]=a2[i++];
            else if (i>mid) a[k]=a2[j++];
            else if ( a2[j].compareTo(a2[i])<0) a[k]=a2[j++];
            else a[k]= a2[i++];

        }
        assert isSorted(a,lo,hi);
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i= lo; i<hi; i++){
            if (a[i+1].compareTo(a[i])<0) return false;
        }
        return true;
    }

}
