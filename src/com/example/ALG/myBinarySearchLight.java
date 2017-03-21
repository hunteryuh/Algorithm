package com.example.ALG;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by HAU on 3/9/2017.
 */
public class myBinarySearchLight {
    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */

    public static int indexOf(int[] a, int key){
        int lo = 0;
        int hi = a.length-1;


        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if ( key > a[mid]){
                lo = mid+1;
                //mid = lo + (hi-lo)/2;
            } else if (key<a[mid]){
                hi = mid-1;
                //mid = lo + (hi-lo)/2;
            } else return mid;
        }
        return -1;



    }
    public static void main(String[] args){
        int[] b = {3,5,0,4,7,10};
        int key = 4;

        Arrays.sort(b);

        //if (myBinarySearchLight.indexOf(b,key)==-1)
            //StdOut.println(key);
        //else StdOut.println("index is " + indexOf(b,key)+ ", value is " + key);
        StdOut.println("index is " + indexOf(b,key)+ ", value is " + key);
    }
}
