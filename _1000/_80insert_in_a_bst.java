package _1000;

public class _80insert_in_a_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root , int key){
        if(root == null){
            return new Node(key);
        }
        if(key < root.data){
            root.left = insert(root.left , key);
        }
        if(key > root.data){
            root.right = insert(root.right , key);
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
}
