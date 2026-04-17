package _1000;

public class _82insert_in_doubly_linkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node head , int pos , int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        if(pos == 1){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        Node temp = head;
        for(int i = 1;  temp != null && i<pos; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("position out of bounds : ");
            return head;
        }
        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev = newNode;
        temp.prev.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        
    }
}
