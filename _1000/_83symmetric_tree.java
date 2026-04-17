package _1000;

public class _83symmetric_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean symmetrix(Node root){
        return check_symmetric(root.left , root.right);
    }
    public static boolean check_symmetric(Node root1 , Node root2){
        if(root1 == null && root1 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return check_symmetric(root1.left , root2.right) && check_symmetric(root1.right, root2.left);
    }
    public static void main(String[] args) {
        
    }
}
