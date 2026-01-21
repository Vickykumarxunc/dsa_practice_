import java.util.LinkedList;
import java.util.Queue;

public class _107maximum_sum_bst {
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
        boolean isbst; // check current subtree is bst or not : 
        int sum; // agar bst hai to uska sum 
        int min; // subtree ki minimum value : 
        int max; // subtree is maximum value : 
        int max_sum; // maximum sum 
        info(boolean isbst , int sum , int min , int max , int max_sum){
            this.isbst = isbst;
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.max_sum = max_sum;
        }
    }
    public static info solve(Node root){

        // base case : 
        // agar tree empty hai : 
        // to vo bst to hoga hi 
        if(root == null){
            return new info(true , 0 , Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }

        // phle left aur right subtree se information lo : 
        info left = solve(root.left);
        info right = solve(root.right);

        // ab check karo ki current subtree bst hai ya nahi : 
        if(left.isbst && right.isbst && root.data > left.max && root.data < right.min){

            // agar current subtree hi bst hai to : 
            int current_sum = left.sum + right.sum + root.data;
            int curr_min = Math.min(root.data , left.min);
            int curr_max = Math.max(root.data , right.max);

            // agar current subtree hi maximum sum ke bst ho to : 
            int max_sum = Math.max(current_sum , Math.max(left.max_sum , right.max_sum));

            // ab aishe hi har subtree ke liye check karo : 
            return new info(true , current_sum , curr_min , curr_max , max_sum);
        }
        // agar current subtree bst nahi hua to : 
        // to max_sum ya to left subtree ke bst ka hoga ye right subtree ke bst ka hoga: 
        int max_sum = Math.max(left.max_sum , right.max_sum);
        return new info(false , 0 , 0 , 0 , max_sum);
    }
    public static int max_sum_bst(Node root){
        return solve(root).max_sum;
    }

    public static void main(String[] args) {
        String arr[] = {"5" , "2" , "4" , "1" , "3" , " "};
        Node root = createNode(arr);
        int ans = max_sum_bst(root);
        System.out.println(ans);

    }
}

/*
Binary Tree ke andar jo BST subtree ka sum maximum ho, uska sum return karna hai.
 */
