package _1000;
public class _283minimum_absolute_difference_in_bst{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    // apply the inorder and track the prev node : 
    public static void find(Node root , int prev[] , int min_diff[]){
        if(root == null){
            return;
        }
        find(root.left , prev , min_diff);
        if(prev[0] != -1){
            min_diff[0] = Math.min(min_diff[0] , root.data - prev[0]);
        }
        prev[0] = root.data;
        find(root.right , prev , min_diff);
    }
    public static int minimum_difference(Node root){
        int prev[] = new int[]{-1};
        int min_diff[] = new int[]{Integer.MAX_VALUE};
        find(root , prev , min_diff);
        return min_diff[0];
    }
    public static void main(String[] args) {
        
    }
}