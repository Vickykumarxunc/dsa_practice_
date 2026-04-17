package _1000;

public class _33height_of_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    public static void main(String[] args) {
        
    }
}
