package _1000;

public class _108maximum_sum_bst {
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
        int sum;
        int max_sum;
        info(boolean isbst , int min , int max , int sum , int max_sum){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.max_sum = max_sum;
        }
    }
    public static int maximum_sum(Node root){
        return solve(root).max_sum;
    }
    public static info solve(Node root){
        if(root == null){
            return new info(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0 , 0);
        }
        info left = solve(root.left);
        info right = solve(root.right);

        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int curr_sum = left.sum + right.sum + root.data;
            int curr_min = Math.min(root.data , left.min);
            int curr_max = Math.max(root.data , right.max);
            int max_sum = Math.max(curr_sum , Math.max(left.max_sum , right.max_sum));
            return new info(true , curr_min , curr_max , curr_sum , max_sum);
        }
        int max_sum = Math.max(left.max_sum , right.max_sum);
        return new info(false , 0  , 0 , 0 , max_sum);
    }
    public static void main(String[] args) {
        
    }
}
