package _1000;
import java.util.HashSet;

public class _51remove_duplicate_from_unsorted_linkedlist {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node remove(Node head){
        if(head == null || head.next == null){
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        Node dummyNode = new Node(-1);
        Node curr = head;
        Node prev = dummyNode;

        while(curr != null){
            if(!set.contains(curr.data)){
                prev.next = curr;
                prev = prev.next;
            }
            set.add(curr.data);
            curr = curr.next;
        }
        prev.next = null;
        return dummyNode.next;
    }
    public static void main(String[] args) {
        
    }
}
