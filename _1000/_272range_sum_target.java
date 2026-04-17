package _1000;

public class _272range_sum_target {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int range_sum(Node root , int low , int high){
        if(root == null){
            return 0;
        }
        // left : 
        if(root.data > high){
            return range_sum(root.left , low , high);
        }
        // right : 
        if(root.data < low){
            return range_sum(root.right , low , high);
        }
        // if in range : add : 
        return root.data + range_sum(root.left , low , high) + range_sum(root.right , low , high);
    }
    public static void main(String[] args) {
        
    }
}
