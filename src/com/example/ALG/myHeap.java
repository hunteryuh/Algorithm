package com.example.ALG;

/**
 * Created by HAU on 3/28/2017.
 */
public class myHeap {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }

    private static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N/2; i>=1; i--)
            sink(a,i,N);
        while(N>1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    private static void sink(Comparable[] a, int i, int n) {
        while (2*i<=n){
            int j = 2*i;

            if( a[i-1].compareTo(a[j-1])<0 && a[j-1].compareTo(a[j])<0) j++;
            if (a[i-1].compareTo(a[j-1])>0) break;
            exch(a,i,j);
            i = j;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i-1];
        a[i-1] = a[j-1];
        a[j-1]= swap;
    }


    private static void show(String[] a) {
        for (int i = 0; i<a.length;i++)
            StdOut.println(a[i]);
    }
}
