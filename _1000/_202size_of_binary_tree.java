package _1000;

public class _202size_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data  = data;
        }
    }
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    
    public static void main(String[] args) {
        
    }
}
