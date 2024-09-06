package org.datastructures.stack;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStackUsingReflection<Item> implements Iterable<Item> {

    private Class<Item[]> itemArrayClass;

    private static final int INIT_CAPACITY = 8;
    private Item[] a;
    private int n;

    public ResizingArrayStackUsingReflection(Class<Item[]> itemArrayClass){
        this.itemArrayClass = itemArrayClass;
        a = itemArrayClass.cast(Array.newInstance(itemArrayClass.getComponentType(), INIT_CAPACITY));
        n = 0;
    }

    private void push(Item item){
        if(n == a.length) resize(2 * a.length);
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
        Item[] temp = itemArrayClass.cast(Array.newInstance(itemArrayClass.getComponentType(), capacity));
        for(int i = 0; i < n; i++){
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
        System.out.println();
    }

    private void shellSort(){
        int h = 1;
        int len = n;
        while(h < len/2) h = 3 * h + 1;
        while(h >= 1){
            for(int i = h; i < len; i++){
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    Item t = a[j];
                    a[j] = a[j - h];
                    a[j - h] = t;
                }
            }
            h = h/3;
        }
    }
    private boolean less(Item v, Item w){
        return ((Comparable<Item>) v).compareTo(w) < 0;
    }

    private void rotateArray(Item k){
        int start = 0;
        int end = n - 1;
       // if(k == a[start] && k == a[end]) return;
        while(start < end){
            for(int i = 0; i < n; i++) {
                if (a[i] == k) {
                    Item t = a[start];
                    a[start] = a[end];
                    a[end] = t;
                }
            }
            start++;
            end--;
         }
    }

    public static void main(String[] args) {
        ResizingArrayStackUsingReflection<String> reflectionStack = new ResizingArrayStackUsingReflection<>(String[].class);

        reflectionStack.push("T");
        reflectionStack.push("R");
        reflectionStack.push("O");
        reflectionStack.push("J");
        reflectionStack.push("A");
        reflectionStack.push("N");
        reflectionStack.push("W");
        reflectionStack.push("K");
        reflectionStack.push("B");

        reflectionStack.show();
 /*       reflectionStack.rotateArray("O");
        reflectionStack.show();
        reflectionStack.pop();
        reflectionStack.show();*/
        reflectionStack.shellSort();
        reflectionStack.show();
    }
}
