package _1000;

public class _36remove_duplicate_from_sorted_linkedlist {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node remove_duplicate(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            if(curr.data != prev.data){
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        
    }
}
