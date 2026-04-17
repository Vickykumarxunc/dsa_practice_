package _1000;

public class _109count_bst_in_binary_tree {
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
        int count;
        info(boolean isbst , int min , int max , int count){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }
    public static int count(Node root){
        return solve(root).count;
    }
    public static info solve(Node root){
        if(root == null){
            return new info(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }
        info left = solve(root.left);
        info right = solve(root.right);

        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int count = left.count + right.count + 1;
            int curr_min = Math.min(root.data , left.min);
            int curr_max = Math.max(root.data , right.max);

            return new info(true , curr_min , curr_max , count);
        }
        int count = left.count + right.count;
        return new info(false , 0 , 0 , count);
    }
    public static void main(String[] args) {
        
    }
}
