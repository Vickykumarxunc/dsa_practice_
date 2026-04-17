package _1000;

public class _322palindrome_linkedList {
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
        Node curr = head;
        Node prev = null;
        Node forw = null;

        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public static boolean palindrome(Node head){

        // agar list null hai ya list me ek hi node hai 
        // to vo hamesa palindrome hogai : 
        if(head == null || head.next == null){
            return true;
        }

        // phle mid nikalo 
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // ab second half ko reverse karo : 
        Node newhead = reverse(slow);

        // apply the palindrome logic : 
        Node temp1 = head;
        Node temp2 = newhead;

        while(temp1 != null && temp2 != null){
            
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
