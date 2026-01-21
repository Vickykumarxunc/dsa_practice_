
import java.util.LinkedList;
import java.util.Queue;

public class _98inorder_predecessor_and_successor {
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

    // time complexity = height of tree : 
    public static int successor(Node root , int x){

        // apply the iterative approach : 
        int successor = -1;
        while(root != null){
            if(root.data > x){

                // successor ko update kar do : 
                successor = root.data;

                // or chota but x se bade ke liye left side me search karo : 
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return successor;
    }
    public static int predecessor(Node root , int x){

        int predecessor = -1;
        while(root != null){

            if(root.data < x){
                predecessor = root.data;
                // isse or bada mil sakta hai but x se chota : 
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return predecessor;
    }
    public static void main(String[] args) {
        String arr[] = {"20" , "8" , "22" , "4" , "12" , " " , " " , " " , " " , "10" , "14" , " "};
        Node root = createNode(arr);
        int successor = successor(root , 8);
        System.out.println(successor);
        int predecessor = predecessor(root, 8);
        System.out.println(predecessor);

        
    }
}
