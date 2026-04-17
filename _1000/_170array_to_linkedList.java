package _1000;

public class _170array_to_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node array_to_linkedList(int arr[] , int n){
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        for(int i = 0; i<n; i++){
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            curr = curr.next;
        }
        return dummyNode.next;
    }
   public static void main(String[] args) {
        
    }
}
