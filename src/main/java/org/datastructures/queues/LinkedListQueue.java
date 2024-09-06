package org.datastructures.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<Item> implements Iterable<Item> {
    private Node<Item> first; // beginning of queue
    private Node<Item> last; // end of queue
    private int n;          // number of elements on queue

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public LinkedListQueue(){
        first = null;
        last = null;
        n = 0;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private int size(){
        return n;
    }

    private Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    private void enqueue(Item item){
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    private void insertFirst(Item item){
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = null;
        if(isEmpty()) last = first;
        else first.next = oldFirst;
        n++;
    }

    private Item dequeue(){
        Item current = first.item;
        first = first.next;
        n--;
        if(isEmpty()) last = null;
        return current;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator<>(first);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Item item : this){
            builder.append(item);
            builder.append(' ');
        }
        return builder.toString();
    }

    private class LinkedListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;
        public LinkedListIterator(Node<Item> first){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.insertFirst(20);
        queue.insertFirst(30);
        queue.insertFirst(50);
        queue.insertFirst(60);

        System.out.println(queue);
        System.out.println(queue.peek());
        //System.out.println(queue);
    }

}
