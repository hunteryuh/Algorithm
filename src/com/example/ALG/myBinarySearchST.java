package com.example.ALG;

/**
 * Created by HAU on 3/30/2017.
 */
// ordered elements in the symbol table
public class myBinarySearchST <Key extends Comparable<Key>, Value>{
    private static final int INITIAL_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public myBinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }

    public boolean contains(Key key){
        return get(key)!=null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null for get");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return values[i];
        return null;
    }


    /** return the number of keys in this ST strictly less than key
     *
     * @param key
     * @return the number of keys less than key
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null for rank");

        int lo = 0, hi = n-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            int comp = key.compareTo(keys[mid]);
            if (comp<0) hi = mid-1;
            else if (comp>0) lo = mid +1;
            else return mid;
        }
        return lo;
    }
    public void put(Key key, Value value){
        if (key == null) throw new IllegalArgumentException("key is null for put");

        if (value == null){
            delete(key);
            return;
        }

        int i = rank(key);

        // key is already in the ST
        if (i<n && key.compareTo(keys[i])==0) {
            values[i] = value;
            return;
        }

        // key is not in the ST yet, insert this key-value pair
        // check the size of the table
        if (n == keys.length) resize(2*keys.length);
        for (int j = n;j>i;j--){  // previously the largest key index is n-1
            keys[j]=keys[j-1];
            values[j] = values[j-1];

        }
        keys[i]= key;
        values[i] = value;
        n++;


    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null for delete");
        if (isEmpty()) return;
        int i = rank(key);
        // if key is not in the table
        if (i == n || key.compareTo(keys[i])!=0) return;

        // if key is int the table
        for (int j = i; j<n-1;j++){
            keys[j]= keys[j+1];
            values[j] = values[j+1];
        }
        n--;  // the length changed to n-1
        keys[n] = null;  // n is the original n-1, the last index
        values[n] = null; // avoid loitering

        // when to resize after deletion
        if (n>0 && n == keys.length/4) resize(keys.length/2);


    }

    public void resize(int capcity) {
        Key[] tempkeys = (Key[]) new Comparable[capcity];
        Value[] tempvalues = (Value[]) new Comparable[capcity];
        for (int i = 0; i < n; i++){
            tempkeys[i] = keys[i];
            tempvalues[i]=values[i];
        }
        keys = tempkeys;
        values = tempvalues;
    }


}


