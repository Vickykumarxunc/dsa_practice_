import java.util.LinkedList;
import java.util.Queue;

public class _80Insert_a_Node_in_bst {
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
    public static Node insert(Node root , int data){
        
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return root;
        }
        // insert in the right  side of the root : 
        if(root.data < data){
            root.right =  insert(root.right , data);
        }
        // insert in the left side of the root : 
        if(root.data > data){
            root.left =  insert(root.left , data);
        }
        return root;
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
        String arr[] = {"2" , "1" , "3" , " "};
        Node root = createNode(arr);
        print(root);

        System.out.println();

        root = insert(root, 4);
        print(root);
    }
}
