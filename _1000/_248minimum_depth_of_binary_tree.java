package _1000;

public class _248minimum_depth_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int minimum_depth(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + minimum_depth(root.right);
        }
        if(root.right == null){
            return 1 + minimum_depth(root.left);
        }
        return 1 + Math.min(minimum_depth(root.left) , minimum_depth(root.right));
    }
    public static void main(String[] args) {
        
    }
}
