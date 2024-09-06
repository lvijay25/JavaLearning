package org.datastructures.linkedlist;

public class SinglyLinkedListSwap {

    ListNode head;

    static class ListNode{
        int data;
        ListNode next;
    }

    public void SwapHeadWithTail(){

        if(head == null){
            return;
        }
        // 10 ---> 12 ---> 12 ---> 14 ---> 16 ---> 16 ---> 16 ---> 10 ---> null

        ListNode temp = head;
        ListNode tail = head.next;
        head = head.next;
        temp.next = null;

        tail = temp.next;
        
    }
}
