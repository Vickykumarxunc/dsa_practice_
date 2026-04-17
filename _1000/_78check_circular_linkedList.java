package _1000;

public class _78check_circular_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean check_circular(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next == head){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
