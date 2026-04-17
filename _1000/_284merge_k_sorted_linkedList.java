package _1000;

import java.util.PriorityQueue;

public class _284merge_k_sorted_linkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node merge(Node arr[]){

        // create a min heap 
        // initially hum heap me har list ke heap push kar de ge : 
        PriorityQueue<Node> pq = new PriorityQueue<>((a , b)-> a.data - b.data);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != null){
                pq.add(arr[i]);
            }
        }
        // create a answer list : 
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;

        // heap par traverse karo 
        // minimum element nikalo use answer me add karo 
        // jis list ka minimum answer me add kara us list ka next node heap me push karo : 
        while(!pq.isEmpty()){
            Node node = pq.remove();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummyNode.next;
    }
    public static void main(String args[]){

    }
}
