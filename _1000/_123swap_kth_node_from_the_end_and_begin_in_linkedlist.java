package _1000;

public class _123swap_kth_node_from_the_end_and_begin_in_linkedlist {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node swap_Node(Node head , int k){
        if(head == null || head.next == null){
            return head;
        }
        int n = 0;
        Node temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        if(k > n){
            return head;
        }
        if(2 * k - 1 == n){
            return head;
        }
        Node prev_x = null;
        Node x = head;
        for(int i = 1; i<k; i++){
            prev_x = x;
            x = x.next;
        }
        Node prev_y = null;
        Node y  = head;
        for(int i = 1; i< n - k + 1; i++){
            prev_y = y;
            y = y.next;
        }
        if(prev_x != null){
            prev_x.next = y;
        }
        if(prev_y != null){
            prev_y.next = x;
        }
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;

        if(k == 1){
            head = y;
        }
        if(k == n){
            head = x;
        }
        return head;

    }
    public static void main(String args[]){

    }
}
