package com.example.ALG;

import edu.princeton.cs.algs4.StdOut;



/**
 * Created by HAU on 3/20/2017.
 */
public class mySelection {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        mySelection.sort(a);
        show(a);
    }
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j= i+1 ; j<n; j ++){
                if (a[j].compareTo(a[min])<0) min = j;
            }
            exch(a,i,min);
        }
    }
    public static void exch(Comparable[] a, int i, int j ){
        Comparable swap = a[j];
        a[j]= a[i];
        a[i]= swap;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i< a.length; i++){
            StdOut.println(a[i]);
        }
    }
}
