package _1000;

public class _302first_node_of_cycle {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int first_node_of_cycle(Node head){
        if(head == null || head.next == null){
            System.out.println("cycle is not present : ");
            return -1;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // agar cycle detect ho gayi 
            // to slow ko head par le jaoi aur first node find karo cycle ka : 
            if(slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                // slow first node par hi point karege : 
                return slow.data;
            }
        }
        // ye kabhi chalege hi nahi agar cycle present hai : 
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
