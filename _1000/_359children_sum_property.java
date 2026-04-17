package _1000;

public class _359children_sum_property {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean children_sum_property(Node root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int left = (root.left != null) ? root.left.data : 0;
        int right = (root.right != null) ? root.right.data : 0;

        if(root.data != left + right){
            return false;
        }
        return children_sum_property(root.left) && children_sum_property(root.right);
    }
    public static void main(String args[]){

    }
    
}
