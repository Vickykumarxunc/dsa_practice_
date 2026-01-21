public class _28reverse_a_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node head , int data){

        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next  = newNode;
        return head;
    }
    public static Node reverse(Node head){

        // agar list empty hai ya useme ek ho node present hai to use direct return kar do : 
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = head;

        while(curr != null){
            
            // preserve the add ress of the next node : 
            next = curr.next;
            
            // reverse the direction of link : 
            curr.next = prev;
            prev = curr;

            // update the curr : 
            curr = next;
        }
        
        return prev;
    }
    public static void print(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);

        print(head);
       head =  reverse(head);
        print(head);
    }
}
