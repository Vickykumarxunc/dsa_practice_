package _1000;

public class _300remove_loop_in_a_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void remove(Node head){

        // is list is null or contain only one node : 
        if(head == null || head.next == null){
            return;
        }
        // take two pointer slow and fast : 
        Node slow = head;
        Node fast = head;

        // first detect the loop : 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // if loop is present : 
            if(slow == fast){

                // to slow ko head par le aao : 
                slow = head;

                // agar loop head se hi stat ho : 
                if(slow == fast){
                    while(fast.next != null){
                        fast = fast.next;
                    }
                    fast.next = null;
                    return;
                }
                // ab loop ka first node find karo 
                // aur uska pre maintain karo : 
                Node prev = null;
                while(slow != fast){
                    prev = fast;
                    fast = fast.next;
                    slow = slow.next;
                }
                prev.next = null;
                return;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
