public class _24middle_of_linkedList {
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
        temp.next = newNode;
        return head;
    }
    public static int middle(Node head){

        // take the two pointer : 
        Node slow = head;
        Node fast = head;

        // slow ek step se chalege 
        // fast do step ek sath chalega : 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    } 
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);
        head = insert(head , 5);

        int middleNode = middle(head);
        System.out.println("middle node of the linkedlist = " + middleNode);

    }
}
