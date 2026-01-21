import java.util.Queue;
import java.util.LinkedList;
public class _143searchNodeInBst {
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
    //iterative :: O(height)
    public static boolean search1(Node root , int target){
        while(root != null){

            // find the target element : 
            if(root.data == target){
                return true;
            }
            // go the right side : 
            else if(root.data < target){
                root = root.right;
            }
            // go the left side : 
            else{
                root = root.left;
            }
        }
        return false;
    }
    // recursive :: O(height)
    public static boolean search2(Node root , int target){
        // base condition : 
        if(root == null){
            return false;
        }
        // condition match : 
        if(root.data == target){
            return true;
        }
        // go to left side : 
        if(root.data > target){
            return search2(root.left , target);
        }
        // go to right side : 
        else{
            return search2(root.right , target);
        }
    }
    public static void main(String[] args) {
        String arr[] = {"6" , "2" , "8" , " " , " " , "7" , "9" , " "};
        Node root = createNode(arr, arr.length);
        int target = 8;
        boolean ans = search2(root, target);
        System.out.println(ans);
    }
}
