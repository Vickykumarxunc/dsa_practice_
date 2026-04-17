package _1000;

public class _244sum_of_left_leaf_node {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int sumOfLeftLeaf(Node root){
        // base condition :
        if(root == null){
            return 0;
        }
        int ans = 0;
        if(root.left != null){
            
            // condition of left leaf Node 
            if(root.left.left == null && root.left.right == null){
                ans += root.left.data;
            }
            // agar root.left null nahi hai to use explore koro 
            ans += sumOfLeftLeaf(root.left);
        }
        // always check the right subtree : 
        ans += sumOfLeftLeaf(root.right);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
