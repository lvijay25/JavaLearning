package org.datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;
    private Item[] a;
    private int n;

    public ResizingArrayStack(){
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    private void push(Item item){
        if(n == a.length) resize(2*a.length);
        a[n++] = item;
    }
    private Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;
        n--;
        if(n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    private Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }

    private boolean isEmpty(){
        return n == 0;
    }

    private int size(){
        return n;
    }

    private void resize(int capacity){
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for(int i = 0; i <= n; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<Item>{
        public int i = 0;
        public ResizingArrayIterator(){
            i = n-1;
        }

        @Override
        public boolean hasNext() {
            return n >= 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("Stack Underflow");
            return a[i--];
        }
    }

    private void show(){
        for(Item item : a) System.out.print(item + " ");
    }

    public static void main(String[] args){
        ResizingArrayStack<String> resizingStack = new ResizingArrayStack<>();
        resizingStack.push("T");
        resizingStack.push("R");
        resizingStack.push("O");
        resizingStack.push("J");
        resizingStack.push("A");
        resizingStack.push("N");
        resizingStack.push("R");
        resizingStack.push("A");

        resizingStack.show();

    }
}
