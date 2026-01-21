import java.util.LinkedList;
import java.util.Queue;

public class _128leves_at_same_level_or_not {
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
    
    public static boolean leaves_at_same_level_or_not(Node root){

        // isme jo phli leaf node hogi uska level hum store kar le ge 
        // aur fir baaki leaf node ka level first leaf node ke level se comapre karege : 
        // agar equal nahi hai to false return kar do : 
        int leaflevel[] = new int[]{-1};
        return check(root , leaflevel , 1);
    }
    public static boolean check(Node root , int leaflevel[] , int level){
        if(root == null){
            return true;
        }
        // condition of the leaf node : 
        if(root.left == null && root.right == null){

            // first leaf node ka level : 
            if(leaflevel[0] == -1){
                leaflevel[0] = level;
                return true;
            }
            // check with another leaf node level : 
            return level == leaflevel[0];
        }
        // check for left and right subtree : 
        return check(root.left , leaflevel , level + 1) && check(root.right , leaflevel , level + 1);
    }
    
    public static void main(String[] args) {
        String arr[] = {"10" , "20" , "30" , "10" , "15" , " "};
        Node root = createNode(arr , arr.length);
        
        boolean ans = leaves_at_same_level_or_not(root);
        System.out.println("leaves at same level or not =  " + ans);

    }
    // space complextiy O(height)
    // time : O(n)
}
