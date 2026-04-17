package _1000;

public class _199sum_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }
    public static void main(String[] args) {
        
    }
}
