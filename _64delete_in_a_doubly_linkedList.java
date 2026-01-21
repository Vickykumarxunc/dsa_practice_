public class _64delete_in_a_doubly_linkedList {
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
    public static Node delete(Node head , int pos){
        if(pos == 1){
             if(head != null){
                head = head.next;
                if(head != null){
                    head.prev = null;
                }
             }
             return head;
        }
        Node temp = head;
        for(int i = 1; temp != null && i < pos; i++){
            temp = temp.next;
        }
        // position is out of range : 
        if(temp == null){
            return head;
        }
        // connect previous node to next node : 
        if(temp.prev != null){
            temp.prev.next = temp.next;
        }
        // connect next node back to previous node 
        if(temp.next != null){
            temp.next.prev = temp.prev;
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
        head = insert(head , 3);
        head = insert(head , 4);
        print(head);
        head = delete(head, 1);
        print(head);
    }
}
