import java.util.LinkedList;
import java.util.Queue;

public class _60minimum_element_in_bst {
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
    public static int minimumElement(Node root){
        if(root == null){
            return -1;
        }
        if(root.left == null){
            return root.data;
        }
        // minimum element always present in left most side : 
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    public static int maximumElement(Node root){
        if(root == null){
            return -1;
        }
        if(root.right == null){
            return root.data;
        }
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
    public static void main(String[] args) {
        String arr[] = {"5" , "4" , "6" , "3" , " " , " " , "7" , "1" , " "};
        Node root = createNode(arr, arr.length);

        int min = minimumElement(root);
        System.out.println("minimum element in the bst = " + min);
        int max = maximumElement(root);
        System.out.println("maximum element in bst = " + max);

    }
}
