package com.example.ALG;

/**
 * Created by HAU on 3/22/2017.
 */
public class myMerge {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }
    public static void show(Comparable[] a){
        for (int i=0; i<a.length;i++){
            StdOut.println(a[i]);
        }
    }
    public static void sort(Comparable[] a){
        Comparable[] a2 = new Comparable[a.length];
        sort(a,a2,0,a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] a2, int lo, int hi) {
        if (hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,a2,lo,mid);
        sort(a,a2,mid+1,hi);
        merge(a,a2,lo,mid,hi);

    }

    private static void merge(Comparable[] a, Comparable[] a2, int lo, int mid, int hi) {
        assert isSorted(a,lo,mid);
        assert isSorted(a,mid+1,hi);
        for (int k = lo; k<=hi; k++) a2[k]=a[k];
        int i = lo;
        int j= mid + 1;
        for (int k = lo; k<=hi; k++){
            if (i > mid) a[k]=a2[j++];
            else if(j>hi) a[k]=a2[i++];
            else if (a2[j].compareTo(a2[i]) < 0) a[k]=a2[j++];
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
