package _1000;

public class _97delete_node_having_greater_value_on_right {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node next = head;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node remove(Node head){
        if(head == null || head.next == null){
            return head;
        }

        head = reverse(head);

        Node curr = head;
        int max = head.data;

        while(curr != null && curr.next != null){
            if(curr.next.data < max){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
                max = curr.data;
            }
        }
        head = reverse(head);
        return head;
    }
    public static void main(String[] args) {
        
    }
}
