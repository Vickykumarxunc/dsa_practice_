public class _53delete_in_a_singly_linkedList {
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
    public static Node delete(Node head , int pos){
        if(pos == 1){
            return head.next;
        }
        Node prev = null;
        Node curr = head;
        for(int i = 1; curr != null && i < pos; i++){
            prev = curr;
            curr = curr.next;
        }
        // now delete the node : 
        if(curr != null){
            prev.next = curr.next;
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
        print(head);
        head = delete(head, 3);
        print(head);

    }
}
