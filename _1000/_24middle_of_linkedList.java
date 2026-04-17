package _1000;

public class _24middle_of_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int middle_of_linkedList(Node head){
        if(head == null){
            return 0;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
    
    public static void main(String[] args) {
        
    }
}
