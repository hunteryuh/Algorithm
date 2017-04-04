package com.example.ALG;

import java.util.TreeMap;

/**
 * Created by HAU on 3/29/2017.
 */
public class myST <Key extends Comparable<Key>, Value> {//implements Iterable<Key>

    private TreeMap<Key, Value> st;  // why TreeMap?

    public myST(){
        st = new TreeMap<Key, Value>();
    }
    public void put (Key key, Value value){
        if(key == null) throw new IllegalArgumentException("called put() with null key");
        if(value == null) st.remove(key);
        st.put(key,value);
    }
    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("called get() with null key");
        return st.get(key);
    }
    public boolean contains(Key key){
        return st.get(key)!=null;
    }
    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("null key, cannot delete");
        put(key,null);
    }
    public Iterable<Key> keys() {
        return st.keySet();
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public int size(){
        return st.size();
    }

    public static void main(String[] args) {
        myST<String,Integer> st = new myST<>();
        for (int i = 0; !StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        for (String key:st.keys()){
            StdOut.println(key + " "+ st.get(key));
        }
    }



}
