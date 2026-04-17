package _1000;

public class _273binary_tree_tilt {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int find_tilt(Node root , int tilt[]){
        // tilt of the leaf node is always zero : 
        if(root == null){
            return 0;
        }
        // postorder : 
        int left = find_tilt(root.left , tilt);
        int right = find_tilt(root.right , tilt);

        // calculate tilt : 
        tilt[0] += Math.abs(left - right);

        // return the subtree sum : 
        return root.data + left + right;
    }
    public static int binary_tree_tilt(Node root){
        int tilt[] = new int[]{0};
        find_tilt(root , tilt);
        return tilt[0];
    }
    public static void main(String[] args) {
        
    }
}
