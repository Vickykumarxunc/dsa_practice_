import java.util.LinkedList;
import java.util.Queue;

public class _106largest_bst_in_binary_tree {
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
   // it store the information for every subtree : 
   public static class info{
    boolean isbst; // current subtree bst hai ya nahi: 
    int min; // subtee ka minimum value : 
    int max; // subtree ka maximum value : 
    int size; // agar bst hai to current bst ka size : 
    int largest; // is subtree ke ander largest bst ka size : 

    info(boolean  isbst , int size , int min , int max , int largest){
        this.isbst = isbst;
        this.size = size;
        this.min = min;
        this.max = max;
        this.largest = largest;
    }
   }
   public static info solve(Node root){

    // base case : agar tree empty hai : 
    // empty tree always bst hota hai : 
    // size = 0;
    // largest = 0;
    // min = +infinity 
    // max = -infinity 
    if(root == null){
        return new info(true ,0 ,  Integer.MAX_VALUE , Integer.MIN_VALUE , 0 );
    }

    // apply the post order traversal bottom to top 
    // left aur right se information lo : 
    info left = solve(root.left);
    info right = solve(root.right);

    // check karo current subtree bst ban sakta hai ya nahi : 
    if(left.isbst && right.isbst && left.max < root.data && root.data < right.min){

        // agar current subtree bst hai : 
        int current_size = left.size + right.size + 1;
        int currMin = Math.min(root.data , left.min);
        int currMax = Math.max(root.data , right.max);

        // current subtree hi largest bst ban sakta hai kya : 
        int largest = Math.max(current_size , Math.max(left.largest , right.largest));

        // ye har ek subtree ke liye check karo 
        return new info(true , current_size , currMin , currMax , largest);
    }

    // agar current subtree bst nahi hai : 
    // to fir largest bst left me hoga ya right me hoga : 
    int largest = Math.max(left.largest , right.largest);
    return new info(false , 0 , 0 , 0 , largest);
   }
   public static int largestBst(Node root){
    return solve(root).largest;
   }

    public static void main(String[] args) {
        String arr[] = {"5" , "2" , "4" , "1" , "3" , " "};
        Node root = createNode(arr);

        int ans = largestBst(root);
        System.out.println(ans);

    }
}
