package _1000;

public class _16kth_node_from_the_end_of_linkedlist {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int kth_node_from_end(Node head , int k){
        Node first = head;
        Node second = head;
        for(int i = 0; i<k; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }
    public static void main(String[] args) {
        
    }
}
