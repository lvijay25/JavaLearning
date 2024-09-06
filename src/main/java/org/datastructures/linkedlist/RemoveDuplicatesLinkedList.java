package org.datastructures.linkedlist;

import java.io.*;
import java.util.*;

public class RemoveDuplicatesLinkedList {

    Node head;
    int size = 0;

   static class Node{
        int data;
        Node next;
   }
    public void removeDuplicates(){
        if(head == null){
            return;
        }
        Node current = head;

        while(current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public void removeDuplicateUsingHashSet(){
       HashSet<Integer> hData = new HashSet<>();
       Node current = head;
       Node previous = null;
       while(current.next != null){
           if(hData.contains(current.data)){
               previous.next = current.next;
           }else{
               hData.add(current.data);
               previous = current;
           }
           current = current.next;
       }
    }

    public void push(int data){

        Node new_node = new Node();
        new_node.data = data;

        if(head == null){
            head = new_node;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new_node;
        }
    }

    public void display(){
        Node current = head;
        if(current != null){
            while(current.next != null){
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println(current.data);
        }
    }

    public static void main(String[] args ) throws Exception {

        RemoveDuplicatesLinkedList linkedList = new RemoveDuplicatesLinkedList();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter..");

        int n = sc.nextInt();

        for(int i = 1; i < n; i++){
            if(n <= 10) {
                linkedList.push(sc.nextInt());
            }
        }

        linkedList.removeDuplicates();
        linkedList.display();
        sc.close();

    }
}
