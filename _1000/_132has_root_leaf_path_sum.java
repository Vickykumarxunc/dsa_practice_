package _1000;

public class _132has_root_leaf_path_sum {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean root_to_leaf_path_sum(Node root , int target){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(root.data == target){
                return true;
            }
        }
        return root_to_leaf_path_sum(root.left , target - root.data) || root_to_leaf_path_sum(root.right, target - root.data);
    }
    public static void main(String[] args) {
        
    }
}
