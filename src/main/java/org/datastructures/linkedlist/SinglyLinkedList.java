package org.datastructures.linkedlist;

import java.util.HashSet;

public class SinglyLinkedList {
    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (null != current) {
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        ListNode current = head;
        int count = 1;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public void insertNode(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null != current.next){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertElementAtPosition(int data, int position){
        ListNode node = new ListNode(data);
        if(position == 1){
            node.next = head;
            head = node;
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current;
            current = previous.next;
            node.next = current;
            previous.next = node;
        }
    }
    public ListNode deleteFirstElement(){ //...Delete First Element
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLastElement(){

        if(head == null || head.next == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;

        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;

        return current;
    }

    public void deleteElementAtPosition(int position){
        if(position == 1){
            head = head.next;
        }

        ListNode previous = head;
        int count = 1;
        while(count < position - 1){
            previous = previous.next;
            count++;
        }

        ListNode current;
        current = previous.next;
        previous.next = current.next;

    }

    public boolean searchElement(ListNode node, int key){
        ListNode current = node;

        while(current.next != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void deleteNodeByKey(int key){
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }
        if(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;
    }

   public ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
   }
   // get Nth node of the element from the End of the LinkedList...

    public ListNode getNthNodeFromEnd(int n){
        if(head == null) {
            return null;
        }

        if(n <= 0) {
            throw new IllegalArgumentException("provide the greater then element to return.. " + n);
        }

        ListNode mainPointer = head;
        ListNode refPointer = head;
        int count = 0;
        while(count < n){
            if(refPointer == null){
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
            }
            refPointer = refPointer.next;
            count++;
        }
        while(refPointer != null){
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }

        return mainPointer;
    }

    public void removeDuplicate(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public void removeDuplicateUsingHashSet(){
        HashSet<Integer> hData = new HashSet<>();
        ListNode current = head;
        ListNode previous = null;
        while(current != null){
            if(hData.contains(current.data)){
                previous.next = current.next;
            }else{
                hData.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }
    public ListNode insertNodeSortedList(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            return newNode;
        }

        ListNode current = head;
        ListNode temp = null;

        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        assert temp != null;
        temp.next = newNode;

        return temp;
    }

    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }

        while(current != null && current.data != key){
             temp = current;
             current = current.next;
        }
        if(current == null){ // if traversal point to next. if no data found shouldn't return null
            return;
        }
        temp.next = current.next;
    }

    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public ListNode detectStartPointOfLoop(){ // Floyd's Cycle Detection Algorithm...
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    public ListNode getStartingNode(ListNode slowPtr){
        ListNode temp = head;
        while(temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoopInLinkedList(){ // Remove loop using Floyd's Cycle Detection Algorithm...
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                removeLoopMethod(slowPtr);
                return;
            }
        }
    }

    public void removeLoopMethod(ListNode slowPtr){
        ListNode temp = head;
        while (slowPtr.next != temp.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static ListNode mergeDualSortedList(ListNode a, ListNode b){
         ListNode dummyNode = new ListNode(0);
         ListNode tail = dummyNode;
         
         while(a != null && b != null) {
             if (a.data <= b.data) {
                 tail.next = a;
                 a = a.next; // it's required to traversal to next node in a;
             } else {
                 tail.next = b;
                 b = b.next;
             }
             tail = tail.next;
         }
             if(a == null){
                 tail.next = b;
             }else{
                 tail.next = a;
             }
        return dummyNode.next;
    }

    public static ListNode addTwoLinkedList(ListNode a, ListNode b){
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        int carry = 0;
        while(a != null || b != null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.insertLast(10);
        singlyLinkedList.insertLast(12);
        singlyLinkedList.insertLast(12);
        singlyLinkedList.insertLast(14);
        singlyLinkedList.insertLast(16);
        singlyLinkedList.insertLast(16);
        singlyLinkedList.insertLast(16);
        singlyLinkedList.insertLast(10);

        System.out.println("SinglyLinked List");
        singlyLinkedList.display();
        singlyLinkedList.removeDuplicateUsingHashSet();

        System.out.println("After Deletion of Duplicates..");
        singlyLinkedList.display();

        SinglyLinkedList sll1 = new SinglyLinkedList();

        sll1.insertNode(2);
        sll1.insertNode(3);
        sll1.insertNode(4);

        /*
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(12);
        ListNode fourth = new ListNode(13);
        ListNode fifth = new ListNode(16);
        ListNode sixth = new ListNode(18);

        singlyLinkedList.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth; */

        SinglyLinkedList sll2 = new SinglyLinkedList();

        sll2.insertNode(5);
        sll2.insertNode(6);
        sll2.insertNode(7);
        sll2.insertNode(8);
        /*
        sll2.insertLast(11);
        sll2.insertLast(13);
        sll2.insertLast(15);
        sll2.insertLast(17);
        sll2.insertLast(18); */

        sll1.display();
        sll2.display();

        SinglyLinkedList result = new SinglyLinkedList();

      //  result.head = mergeDualSortedList(sll1.head, sll2.head);
        System.out.println("After merge");
        result.head = addTwoLinkedList(sll1.head, sll2.head);
        result.display();

      //  System.out.println(singlyLinkedList.containsLoop());
        //System.out.println(singlyLinkedList.detectStartPointOfLoop().data);
      //  singlyLinkedList.removeLoopInLinkedList();
       // singlyLinkedList.deleteNodeByKey(1);
      //  singlyLinkedList.display();

        /*
        singlyLinkedList.reverseLinkedList(fourth);
        singlyLinkedList.insertNodeSortedList(14);
        singlyLinkedList.display();

        singlyLinkedList.deleteNode(12);

        singlyLinkedList.display(); */

        /*
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(11);
        ListNode third = new ListNode(12);
        ListNode fourth = new ListNode(13);

        singlyLinkedList.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth; */

     //   singlyLinkedList.display();

     //   ListNode nthValue = singlyLinkedList.getNthNodeFromEnd(1);

     //   System.out.println("nth Node of LinkedList : " + nthValue.data);

       //   singlyLinkedList.removeDuplicate();

      //  System.out.println("removed duplicates LinkedList..");

      //  singlyLinkedList.reverseLinkedList(first);

       // singlyLinkedList.display();

       // System.out.println("Length of a LinkedList : " + singlyLinkedList.length());

      /*
        if(singlyLinkedList.searchElement(fourth, 77)){
            System.out.println("Key found..");
        }else{
            System.out.println("Key not found..");
        } */
      //  singlyLinkedList.display();

      //  singlyLinkedList.deleteFirstElement();

      //  singlyLinkedList.display();

      //  singlyLinkedList.deleteLastElement();

     //   singlyLinkedList.display();

     //   singlyLinkedList.insertElementAtPosition(1136, 1);

      //  singlyLinkedList.display();

     //   singlyLinkedList.deleteElementAtPosition(2);

      //  singlyLinkedList.display();

    }

}