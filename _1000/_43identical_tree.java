package _1000;

public class _43identical_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean check(Node root1 , Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return check(root1.left , root2.left) && check(root1.right , root2.right);
    }
    public static void main(String[] args) {
        
    }
}
