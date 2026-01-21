public class _113insert_in_a_sorted_list {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert_in_sorted_list(Node head , int data){

        // create the new Node : 
        Node newNode = new Node(data);

        // empty list or insert at beginnig : 
        if(head == null || data <= head.data){
            newNode.next = head;
            return newNode;
        }
        Node curr = head;
        
        // find the correct position  w
        while(curr.next != null && curr.next.data <= data){
            curr = curr.next;
        }
        // insert 
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
    public static void display(Node head){
        if(head == null)return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = null;
        head = insert_in_sorted_list(head, 1);
        head = insert_in_sorted_list(head, 2);
        display(head);
    }
}
