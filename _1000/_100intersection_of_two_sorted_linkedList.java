package _1000;

public class _100intersection_of_two_sorted_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node intersection(Node head1 , Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        while(temp1 != null && temp2 != null){
            if(temp1.data == temp2.data){
                Node newNode = new Node(temp1.data);
                curr.next = newNode;
                curr = curr.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if(temp1.data < temp2.data){
                temp1 = temp1.next;
            }
            else{
                temp2 = temp2.next;
            }
        }
        return dummyNode.next;
    } 
    public static void main(String[] args) {
        
    }
}
