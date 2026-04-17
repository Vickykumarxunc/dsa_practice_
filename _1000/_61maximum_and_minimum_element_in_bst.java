package _1000;

public class _61maximum_and_minimum_element_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
    }
    public static int minimum(Node root){
        if(root == null){
            return -1;
        }
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    public static int maximum(Node root){
        if(root == null){
            return -1;
        }
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
    public static void main(String[] args) {
        
    }
}
