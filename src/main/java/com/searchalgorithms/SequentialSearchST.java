package com.searchalgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SequentialSearchST<Key, Value> {
    private int n;
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

   public SequentialSearchST(){}

    private int size(){
        return n;
    }

    private boolean isEmpty(){
        return size() == 0;
    }

    private boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException("argument contains() is empty");
        return get(key) != null;
    }

    private Value get(Key key){
        if(key == null) throw new IllegalArgumentException("argument value is null");

        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key))
                return x.value;
        }
        return null;
    }

    private void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException("first argument put() is null");
        if(value == null){
            delete(key);
            return;
        }
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                x.value = value;
                return;
            }
        }

        first = new Node(key, value, first);
        n++;
    }

    private void delete(Key key){
        if(key == null) throw new IllegalArgumentException("argument key is null");
        first = delete(first, key);
    }

    public Node delete(Node x, Key key){
        if(x == null) return null;
        if(key.equals(x.key)){
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        for(Node x = first; x != null; x = x.next){
            queue.add(x.key);
        }
        return queue;
    }

    public static void main(String[] args){
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("Nolan", 1234);
        st.put("John", 475);
        st.put("Susan", 258);
        st.put("Robbie", 7558);
        st.put("Robert", 3644);

        for(String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println("Key of Person " + st.get("Susan"));
    }
}
