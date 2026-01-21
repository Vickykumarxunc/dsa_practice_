import java.util.LinkedList;
import java.util.Queue;

public class _32balanced_tree_check {
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
    public static int height(Node root){

        // base condition : 
        // empty tree and child node have a zero height : 
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    public static boolean isbalance(Node root){

        // base case : 
        // empty tree and ek node ka tree always balance hota hai : 
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        // ab hum left subtree aur right subtree ki height ko find karege : 
        int left = height(root.left);
        int right = height(root.right);

        // now find the difference : 
        int diff = Math.abs(left - right);

        // check the difference : 
        if(diff > 1){
            return false;
        }
        // aur ye hi kaam hone har subtree ke liye karna hia : 
        return isbalance(root.left) && isbalance(root.right);
    }
    public static void main(String[] args) {
        String arr[] = {"10" , "20" , "30" , "40" , " " , " " , " ", "60" , " "};
        Node root = createNode(arr);
        
        boolean ans = isbalance(root);
        System.out.println("check tree is balanced or not =  "  + ans);

    }
}
