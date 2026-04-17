package _1000;

public class _201maximum_element_inbinary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int max(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data , Math.max(max(root.left) , max(root.right)));
    }
    public static void main(String[] args) {
        
    }
}
