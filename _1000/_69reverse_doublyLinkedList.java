package _1000;

public class _69reverse_doublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head;
        Node temp = null;

        while(curr != null){
            
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            curr = curr.prev;
        }
        if(temp != null){
            head = temp.prev;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
}
