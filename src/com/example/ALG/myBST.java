package com.example.ALG;

import java.util.TreeMap;

/**
 * Created by HAU on 3/29/2017.
 */
public class myBST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public myBST(){


    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return size(root);
    }
    private int size(Node node){  // private for this size()
        if (node == null) return 0;
        else         return node.size;
    }

//    public void put (Key key, Value value){
//        if(key == null) throw new IllegalArgumentException("called put() with null key");
//        if(value == null) st.remove(key);
//        st.put(key,value);
//    }

//    public boolean contains(Key key){
//        return get(key)!=null;
//    }
//    public Value get(Key key){
//        if(key == null) throw new IllegalArgumentException("called get() with null key");
//        return get(root,key);
//    }

//    private Value get(Node root, Key key) {   // private for this get method (with root as a node)
//
//    }

//    public void delete(Key key){
//        if (key == null) throw new IllegalArgumentException("null key, cannot delete");
//        put(key,null);
//    }



//    public static void main(String[] args) {
//        myBST<String,Integer> st = new myBST<>();
//        for (int i = 0; !StdIn.isEmpty();i++){
//            String key = StdIn.readString();
//            st.put(key,i);
//        }
//        for (String key:st.keys()){
//            StdOut.println(key + " "+ st.get(key));
//        }
//    }



}
