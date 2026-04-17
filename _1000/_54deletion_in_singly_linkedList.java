package _1000;

public class _54deletion_in_singly_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node delete_from_begin(Node head){
        if(head == null || head.next == null){
            return null;
        }
        head = head.next;
        return head;
    }
    public static Node delete_from_end(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        Node prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }
    public static Node delete_from_given_position(Node head , int pos){
        if(head == null){
            return null;
        }
        if(pos == 1){
            head = head.next;
            return head;
        }
        Node temp = head;
        for(int i = 1; temp != null && i<pos; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("position out of bounds : ");
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static void main(String[] args) {
        
    }
}
