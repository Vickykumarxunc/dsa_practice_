
import java.util.LinkedList;
import java.util.Queue;

public class _33height_of_binary_tree {
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
    public static int height(Node root){

        // empty tree aur child node ke height hamesa zero hoti hai : 
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    public static void main(String[] args) {
        String arr[] = {"12" , "8" , "18" , "5" , "11" , " "};
        Node root = createNode(arr);

        int height = height(root);
        System.out.println("height of the tree = " + height);
    }
}
