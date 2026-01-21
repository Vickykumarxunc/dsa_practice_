public class _103delete_middle_of_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node delete(Node head){

        // use the two pointer : 
        Node slow = head;
        Node prev = null;
        Node fast = head;

        while(fast != null && fast.next != null){

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // skip the middle : 
        prev.next = slow.next;
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
    public static void main(String[] args) {
        Node head = null;
        head = insert(head , 1);
        head = insert(head , 2);
        head = insert(head , 3);
        head = insert(head , 4);
        head = insert(head , 5);

        print(head);
        
        head = delete(head);

        print(head);
    }
}
