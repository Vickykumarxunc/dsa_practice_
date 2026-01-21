public class _97delete_node_having_greater_value_on_right {
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
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node curr  = head;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node delete_Node(Node head){

        // base condition : 
        if(head == null || head.next == null){
            return head;
        }
        // first reverse the linkedlist : 
       head =  reverse(head);

       Node curr = head;
       int max = curr.data;

       while(curr.next != null){
        if(curr.next.data < max){
            curr.next = curr.next.next;
        }
        else{
            curr = curr.next;
            max = curr.data;
        }
      }
      // now again reverse the list : 
      head =  reverse(head);
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
        head = insert(head , 12);
        head = insert(head ,  15);
        head = insert(head , 10);
        head = insert(head , 11);
        head = insert(head , 5);
        head = insert(head , 6);
        head = insert(head , 2);
        head = insert(head , 3);

        print(head);
        head = delete_Node(head);
        print(head);
    }
}
