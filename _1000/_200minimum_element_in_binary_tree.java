package _1000;

public class _200minimum_element_in_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int min(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data , Math.min(min(root.left) , min(root.right)));
    }
    public static void main(String[] args) {
        
    }
}
