package com.example.ALG;

/**
 * Created by HAU on 3/26/2017.
 */
public class myQuick3way {
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
        myQuick3way.sort(a);
        show(a);
    }

    private static void sort(Comparable[] a) {
        myShuffle.shuffle(a);
        sort(a,0,a.length-1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) return;
        //int j = partition(a,lo,hi);
        Comparable v = a[lo];
        int lp = lo;
        int rp = hi;
        int i = lo;
        while(i<=rp){

            if (a[i].compareTo(v)<0)
                exch(a,lp++,i++);
            else if(a[i].compareTo(v)>0)
                exch(a,rp--,i);
            else i++;

        }
        sort(a,lo,lp-1);
        sort(a,rp+1,hi);

    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[j];
        a[j]= a[i];
        a[i]= swap;
    }

}
