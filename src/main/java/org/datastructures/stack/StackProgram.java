package org.datastructures.stack;

public class StackProgram {
    private ListNode top;
    private int length;

    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int length(){
        return length;
    }

    public void push(int data){
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }

    public void display(){
        ListNode temp = top;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public ListNode deleteFirst(){
        ListNode temp = top;
        top = top.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast(){
        ListNode current = top;
        ListNode previous = null;

        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;

        return current;
    }

    public static void main(String[] args){

        StackProgram stack = new StackProgram();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.display();
        stack.deleteFirst();
        stack.display();
        stack.deleteLast();
        stack.display();
    }
}
