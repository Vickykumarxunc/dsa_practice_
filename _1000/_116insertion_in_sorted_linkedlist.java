package _1000;

import java.rmi.NotBoundException;

public class _116insertion_in_sorted_linkedlist {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert_begin(Node head , int x){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static Node insert_end(Node head , int x){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static Node insert_position(Node head , int x, int pos){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            return head;
        }
        if(pos == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        Node prev = null;
        for(int i = 0; temp != null && i < pos; i++){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("out of bounds : ");
            return head;
        }
        prev.next = newNode;
        newNode.next = temp;
        return head;
    }
    public static Node insert_in_sorted_linkedList(Node head , int key){
        Node newNode = new Node(key);
        if(head == null){
            return newNode;
        }
        if(key <= head.data){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null && temp.next.data < key){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        
    }
}
