
import java.util.LinkedList;
import java.util.Queue;

public class _125root_to_leaf_path_sum {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createNode(String arr[] , int n){
        int x = Integer.parseInt(arr[0]);
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while(i < n - 1){
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
            if(arr[i + 1].equals( " ")){
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
    public static boolean root_to_leaf_path_sum(Node root , int target){

        // agar tree null hai return false : 
        if(root == null){
            return false;
        }
        // agar main traverse karte karte root node par aagaya : 
        // to main check karuga ki kya root.data == target return true else false : 
        if(root != null && root.left == null && root.right == null){
            if(root.data == target){
                return true;
            }
        }
        // aishe hi mai left tree aur right tree dono ke liye karuga : 
        // agar kisi ek me se true aa gaya to target sum present karta hai : 
        // har bar target ko apane update karte raho : 
        return root_to_leaf_path_sum(root.left, target - root.data) || root_to_leaf_path_sum(root.right, target - root.data);
    }
    public static void main(String[] args) {
        String arr[] = {"1" , "2" , "3" , " "};
        int target = 4;

        Node root = createNode(arr, arr.length);
        boolean ans = root_to_leaf_path_sum(root, target);
        System.out.println(ans);
    }
}
