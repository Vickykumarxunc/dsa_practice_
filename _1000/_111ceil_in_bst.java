package _1000;

public class _111ceil_in_bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int ceil(Node root , int x){
        if(root == null){
            return -1;
        }
        int ceil = -1;
        while(root != null){
            if(root.data >= x){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        
    }
}
