package _1000;

public class _301length_of_cycle_in_linkedLIst {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int length_of_cycle(Node head){
        if(head == null || head.next == null){
            return 0;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // if loop is detected : 
            if(slow == fast){

                int count = 1;
                while(slow.next != fast){
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
    }
}
