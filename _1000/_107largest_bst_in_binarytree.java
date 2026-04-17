package _1000;

public class _107largest_bst_in_binarytree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static class info{
        boolean isbst;
        int min;
        int max;
        int size;
        int largest;
        info(boolean isbst , int min , int max , int size , int largest){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.size = size;
            this.largest = largest;
        }
    }
    public static info solve(Node root){
        if(root == null){
            return new info(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0 , 0);
        }
        info left = solve(root.left);
        info right = solve(root.right);
        
        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int curr_size = 1 + left.size + right.size;
            int curr_min = Math.min(root.data , left.min);
            int curr_max = Math.max(root.data , right.max);
            int largest = Math.max(curr_size , Math.max(left.largest , right.largest));
            return new info(true , curr_min , curr_max , curr_size , largest);
        }
        int largest = Math.max(left.largest , right.largest);
        return new info(false , 0 , 0 , 0 , largest);
    }
    public static int largest_bst(Node root){
        return solve(root).largest;
    }
    public static void main(String[] args) {
        
    }
}
