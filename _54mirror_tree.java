
import java.util.LinkedList;
import java.util.Queue;

public class _54mirror_tree {
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
    public static void mirror(Node root){
        if(root == null){
            return;
        }
        // swap the node of the tree : 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // do for left subtree and right subtree : 
        mirror(root.left);
        mirror(root.right);
    }
    public static void print(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        String arr[] = {"1" , "2" , "3" , " " , " " , "4" , " "};
        Node root = createNode(arr, arr.length);
        print(root);
        mirror(root);
        System.out.println();
        print(root);
    }
}
