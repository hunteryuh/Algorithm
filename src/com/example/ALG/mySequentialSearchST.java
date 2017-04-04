package com.example.ALG;

/**
 * Created by HAU on 3/29/2017.
 */
public class mySequentialSearchST<Key,Value> {
    private int N;
    private Node first;

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public mySequentialSearchST(){}

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    
    public boolean contains(Key key){
        return get(key)!= null;
    }

    private Value get(Key key) {
        if (key == null) throw new IllegalArgumentException(" null key");
        for (Node i = first; i!=null; i=i.next) {
            if (key.equals(i.key))
                return i.value;
        }
        return null;
    }
    private void put(Key key, Value value){
        if (value == null) {
            delete(key);
            return;
        }
        for (Node i = first; i!=null; i=i.next){
            if(key.equals(i.key)){
                i.value = value;
                return;
            }
       
        }
        first = new Node(key,value,first);
        N++;
    }

    private void delete(Key key) {
        first = delete(first,key);
    }

    private Node delete(Node node, Key key) {  // the linkedlist starts from node
        if (node == null) return null;
        if (key.equals(node.key)){
            N--;
            return node.next;
        }
        node.next = delete(node.next,key);  // recursive, if the key is not at the first, go
        // to the next to find the key to delete
        return node;   // return the proper node

    }
}
