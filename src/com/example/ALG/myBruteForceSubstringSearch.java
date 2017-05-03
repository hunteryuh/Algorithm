package com.example.ALG;

/**
 * Created by HAU on 5/2/2017.
 */
public class myBruteForceSubstringSearch {

    public static int search(String query, String text){
        int m = query.length();
        int n = text.length();

        for (int i = 0;i<=n-m;i++){
            int j ;
            for (j = 0; j<m;j++){
                if(text.charAt(i+j)!=query.charAt(j))
                    break;
            }
            if (j==m) return i;
        }
        return n;  // not found
        // equivalent to the system search in java: indexOf method
    }

    public static void main(String[] args) {
        String query = "abc";
        String text = "dbacabt";

        int myindex = search(query,text);
        System.out.println(myindex);
    }
}
