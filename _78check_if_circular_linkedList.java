public class _78check_if_circular_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean check(Node head){
        
        // base condition : 
        if(head == null || head.next == null){
            return false;
        }
        Node temp = head;
        while(temp != null && temp.next != null){

            // condition of the circular linkedlist : 
            if(temp.next == head){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(2);
        Node a = new Node(4);
        Node b = new Node(6);
        Node c = new Node(7);
        Node d = new Node(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = head;

        boolean iscircular = check(head);
        System.out.println("list is circular or not = " + iscircular );

    }
}
