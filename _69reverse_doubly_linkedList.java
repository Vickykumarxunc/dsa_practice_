public class _69reverse_doubly_linkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node head , int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            head.prev = null;
            head.next = null;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }
    public static Node reverse(Node head){

        // edge case : 
        // empty list or ek node ki list always sorted hoti hai : 
        if(head == null || head.next == null){
            return head;
        }
        // ab hum next and previous pointer ko swap karege : 
        Node curr = head;
        Node temp = null;
        
        while(curr != null){

            // swap : 
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // move to next data (which is prev now : )
            curr = curr.prev;
        }
        // temp.prev par new head milega : 
        if(temp != null){
            head = temp.prev;
        }
        return head;
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
        head = insert(head , 5);
        head = insert(head , 6);

        print(head);
        head = reverse(head);
        print(head);
    }
}
