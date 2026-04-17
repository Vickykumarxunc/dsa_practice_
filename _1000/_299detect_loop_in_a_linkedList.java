package _1000;

public class _299detect_loop_in_a_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean detect_loop(Node head){
        if(head == null || head.next == null){
            return false;
        }
        // apply the two pointer slow and fast appraoch 
        // jab slow and fast ek node ko point karege to loop present hai : 
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // if cycle is present  : 
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
