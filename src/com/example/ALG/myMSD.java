package com.example.ALG;

/**
 * Created by HAU on 4/12/2017.
 */
public class myMSD {

    private static final int R = 256;
    private static final int CUTOFF = 8;
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        sort(a);
        for(String string:a)
            StdOut.println(string);
    }
    public static void sort(String[] a){
        int n = a.length;
        String[] a2 = new String[n];
        sort(a,0,n-1,0,a2);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] a2) {

        
        //if (hi <= lo) return;

        if (hi<lo + CUTOFF){
            insertion(a,lo,hi,d);
            return;
        }
           
        
        int[] count = new int[R+2];

        for (int i = lo; i<=hi;i++){
            int c = charAt(a[i],d);
            count[c+2]++;
        }
        for (int r=0;r<R+1;r++)
            count[r+1] +=count[r];

        for (int i = lo;i<=hi; i++){
            int c = charAt(a[i],d);
            a2[count[c+1]++] = a[i];
        }
        for (int i = lo;i<=hi;i++)
            a[i]=a2[i-lo];  //  a2[i-lo] to start from a2[0]

        for(int r=0;r<R;r++)
            sort(a,lo+count[r],lo+count[r+1]-1,d+1,a2);

    }
    private static int charAt(String st,int d){
        if (d==st.length()) return -1;
        return st.charAt(d);
    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i=lo;i<=hi;i++)
            for (int j=i;j>lo;j--)
                if (a[j].substring(d).compareTo(a[j-1].substring(d))<0)
                    exch(a,j,j-1);

    }
    private static void exch(String[] a, int i, int j){
        String temp = a[i];
        a[i]  = a[j];
        a[j]= temp;
    }
}
