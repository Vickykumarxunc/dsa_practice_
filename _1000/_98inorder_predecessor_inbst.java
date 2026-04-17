package _1000;

public class _98inorder_predecessor_inbst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int predecessor(Node root , int x){
        if(root == null){
            return -1;
        }
        int ans = -1;
        while(root != null){
            if(root.data < x){
                ans = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
