package _1000;

public class _203product_of_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int product(Node root){
        if(root == null){
            return 1;
        }
        return root.data * product(root.left) * product(root.right);
    }
    public static void main(String[] args) {
        
    }
}
