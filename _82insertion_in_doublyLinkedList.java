public class _82insertion_in_doublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node head , int data ,int pos){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head;
        for(int i = 0; i<pos; i++){
            temp = temp.next;
        }
        if(temp.next == null){
            temp.next = newNode;
            newNode.prev = temp;
        }
        else{
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
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
        Node head = new Node(0);
        head = insert(head , 1 , 0);
        head = insert(head , 2 , 1);
        head = insert(head , 3 , 2);

        print(head);
    }
}
/*
  Given the head of a doubly-linked list, a position p, and an integer x. Add a new node with value x at the position just after pth node in the doubly linked list and return the head of the updated list.

Note: The position is 0-based indexed
 */