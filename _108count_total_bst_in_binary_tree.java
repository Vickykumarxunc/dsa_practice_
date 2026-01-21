import java.util.LinkedList;
import java.util.Queue;

public class _108count_total_bst_in_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
      public static Node createNode(String arr[]){
        int n = arr.length;
        int x = Integer.parseInt(arr[0]);
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while(i < n  - 1){
            Node left = new Node(-1);
            Node right = new Node(-1);
            Node temp = q.remove();
            if(arr[i].equals(" ")){
                left = null;
            }
            else{
                int l = Integer.parseInt(arr[i]);
                left.data = l;
                q.add(left);
            }
            if(arr[i + 1].equals(" ")){
                right = null;
            }
            else{
                int r = Integer.parseInt(arr[i + 1]);
                right.data = r;
                q.add(right);
            }
            temp.left = left;
            temp.right = right;
            i += 2;
        }
        return root;
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
    public static info solve(Node root){

        // base condition : 
        // agar tre empty hai : 
        if(root == null){
            return new info(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }
        // leaf node bhi bst hota hai : 

        // left and right subtree info : 
        info left = solve(root.left);
        info right = solve(root.right);

        // check karo current subtree bst hai ya nahi :  
        if(left.isbst && right.isbst && root.data > left.max && root.data < right.min){

            // agar current subtree bst hai ya nahi: 
            int curr_min = Math.min(root.data , left.min);
            int curr_max = Math.max(root.data , right.max);

            // count the bst : 
            int count = 1 + left.count + right.count;
            return new info(true , curr_min , curr_max , count);
        }
        // agar current subtree bst nahi hai : 
        int count = left.count + right.count;
        return new info(false , 0 , 0 , count);
    }
    public static int count_bst(Node root){
        return solve(root).count;
    }
    public static void main(String[] args) {
        String arr[] = {"5" , "2" , "4" , "1" , "3" , " "};
        Node root = createNode(arr);
        int ans = count_bst(root);
        System.out.println("no of bst possible = " + ans);

    }
}
