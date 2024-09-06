package com.sortalgorithms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<Key> implements Iterable<Key>{

    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    private PriorityQueue(int initCapacity){
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    // Initializes with empty Priority Queue
    private PriorityQueue(){
        this(1);
    }
    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    private PriorityQueue(int initCapacity, Comparator<Key> comparator){
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    private PriorityQueue(Comparator<Key> comparator){
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys...
     * Takes time proportional to the number of Keys, using sink-based heap construction.
     * @param key the array of keys.
     */

    private PriorityQueue(Key[] keys){
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for(int k = 0; k < n; k++)
           pq[k + 1] = keys[k];
        for(int k = n/2; k >= 1; k--)
            sink(k);
       assert isMaxHeap();
    }

    /**
     * returns true if this priority queue is empty.
     * @return {@code true} if this priority queue is empty
     *         {@code false} otherwise
     */

    private boolean isEmpty(){
        return n == 0;
    }

    /** returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue.
     */
    private int size(){
        return n;
    }

    /**
     * Returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    private Key max(){
        if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    // resize the underlying array to have the given capacity
    private void resize(int capacity){
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for(int k = 0; k <= n; k++){
            temp[k] = pq[k];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param k the new key to add to this priority queue
     */
    private void insert(Key k){
        if(n == pq.length - 1) resize( 2 * pq.length);
        pq[++n] = k;
        swim(n);
        assert isMaxHeap();
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */

    private Key delMax(){
        if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null; // to avoid loitering and help with garbage collection
        if((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }
    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k <= n){
            int j = 2*k;
            if(j < n && less(j, j+1)) j++;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/

    private boolean less(int i, int j){
        if(comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }else{
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j){
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean isMaxHeap() {
        for(int i = 0; i <= n; i++)
            if(pq[i] == null) return false;
        for(int i = n + 1; i < pq.length; i++)
            if(pq[i] != null) return false;
        if(pq[0] != null) return false;
        return isMaxHeapOrdered(1);
    }

    private boolean isMaxHeapOrdered(int k) {
        if( k < n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if(left <= n && less(k, left)) return false;
        if(right <= n && less(k, right)) return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements  Iterator<Key>{

        private PriorityQueue<Key> copy;

        public HeapIterator() {
            if (comparator == null) copy = new PriorityQueue<Key>(size());
            else copy = new PriorityQueue<Key>(size(), comparator);
            for (int i = 0; i <= n; i++)
                copy.insert(pq[i]);
        }
            public boolean hasNext() {
                return !copy.isEmpty();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
            public Key next(){
             if(!hasNext()){
                 throw new NoSuchElementException();
             }
             return copy.delMax();
            }
        }

    public void show(){
        for(int i = 1; i <= n; i++)
            System.out.print(pq[i] + " ");
    }
    public static void main(String[] args){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.insert("T");
        pq.insert("E");
        pq.insert("L");
        pq.insert("E");
        pq.insert("G");
        pq.insert("R");
        pq.insert("A");
        pq.insert("M");

        pq.show();

        System.out.println(pq.delMax() + " ");
        System.out.println(pq.size() + " left on pq");
        pq.show();
    }

}
