package org.datastructures.linkedlist;

public class ReverseLinkedList {
    ListNode head;
    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        // 1 -> 2 -> 3 -> 4 -> 5

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void push(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
        }else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display(ListNode head){
        ListNode current = head;
            while (null != current) {
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println("null");
    }

    public static void main(String[] args){

        ReverseLinkedList linkedList = new ReverseLinkedList();

        linkedList.push(5);
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);


        ListNode first = new ListNode(10);
        ListNode second = new ListNode(11);
        ListNode third = new ListNode(12);
        ListNode fourth = new ListNode(13);
        ListNode fifth = new ListNode(14);

        linkedList.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        linkedList.display(first);
       ListNode reverseLinkedListNode =  linkedList.reverseLinkedList(first);
       linkedList.display(reverseLinkedListNode);
    }

}
