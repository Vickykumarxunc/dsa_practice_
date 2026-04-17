public class _99inorder_successor_inbst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int successor(Node root , int x){
        if(root == null){
            return -1;
        }
        int ans = -1;
        while(root != null){
            if(root.data > x){
                ans = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ans;
    }
    public static void main(String args[]){

    }
}
