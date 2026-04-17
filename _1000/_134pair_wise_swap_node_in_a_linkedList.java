package _1000;

public class _134pair_wise_swap_node_in_a_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node swap(Node head){

        Node curr = head;
        Node prev = null;
        Node forw = null;
        Node temp = null;

        while(curr != null && curr.next != null){

            forw = curr.next;
            temp = forw.next;

            if(prev == null){
                head = forw;
            }
            else{
                prev.next = forw;
            }
            forw.next = curr;
            curr.next = temp;
            prev = curr;
            curr = temp;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
}
