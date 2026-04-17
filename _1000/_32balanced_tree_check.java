package _1000;

public class _32balanced_tree_check {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean check_balanced_tree(Node root){
        return check(root) != -1;
    }
    public static int check(Node root){
        if(root == null){
            return 0;
        }
        int left = check(root.left);
        if(left == -1){
            return -1;
        }
        int right = check(root.right);
        if(right == -1){
            return -1;
        }
        int diff = Math.abs(right - left);
        if(diff > 1){
            return -1;
        }
        return 1 + Math.max(left , right);
    }
    public static void main(String[] args) {
        
    }
}
