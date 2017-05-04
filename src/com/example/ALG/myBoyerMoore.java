package com.example.ALG;

/**
 * Created by HAU on 5/3/2017.
 */
public class myBoyerMoore {
    private final int R ;
    private String query;
    private int[] right;
    public myBoyerMoore(String query){

        this.R = 256;
        this.query = query;

        right = new int[R];
        // initialized as a private table in the class, outside of the constructor
        for(int i =0;i<R;i++)
            right[i] = -1;
        for(int i =0;i<query.length();i++)
            right[query.charAt(i)]=i;


    }

    public int search(String text) {
        int n = text.length();
        int m = query.length();
        int skip;
        for (int i = 0; i<=n-m; i+=skip){
            skip = 0;
            for (int j=m-1;j>=0;j--){
                if (query.charAt(j)!=text.charAt(i+j)){
                    skip = Math.max(1,j-right[text.charAt(i+j)]);
                    break;
                }
            }
            if (skip ==0) return i;
        }
        return n;


    }
    public static void main(String[] args) {
        String query = "abcef";
        String text = "abcabeabcefabefv";

        myBoyerMoore bm1 = new myBoyerMoore(query);
        int position = bm1.search(text);
        System.out.println(position);

    }


}
