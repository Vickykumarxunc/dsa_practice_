
import java.util.LinkedList;
import java.util.Queue;

public class _83symmetric_tree {
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
    public static void invert(Node root){
        if(root == null){
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
    public static boolean same(Node root1 , Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return same(root1.left , root2.left) && same(root2.right , root2.right);
    }
    public static boolean symmetric(Node root){

        // first inver the one subtree of the root : 
        invert(root.left);

        // check two subtree tree is same or not : 
        return same(root.left , root.right);
    }

    public static void main(String[] args) {
        String arr[] = {"10" , "5" , "5" , "2" , " " , " " , "2" , " "};
        Node root = createNode(arr);

        boolean ans = symmetric(root);
        System.out.println("tree is symmetric or not = "  + ans);

    }
}
