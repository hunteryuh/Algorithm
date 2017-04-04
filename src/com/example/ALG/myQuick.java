package com.example.ALG;

/**
 * Created by HAU on 3/26/2017.
 */
public class myQuick {
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        //String[] a = {"T","B","CA","CC"}; //manual input string array
        myQuick.sort(a);
        show(a);
    }

    private static void sort(Comparable[] a) {
        myShuffle.shuffle(a);
        sort(a,0,a.length-1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi+1;
        while(true){
            while(a[++i].compareTo(v)<0)
                if (i==hi) break;
            while(a[--j].compareTo(v)>0)
                if (j==lo) break;
            if (i>= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[j];
        a[j]= a[i];
        a[i]= swap;
    }

}
