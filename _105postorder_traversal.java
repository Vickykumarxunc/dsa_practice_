import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _105postorder_traversal {
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
    public static void get(Node root , ArrayList<Integer> list ){
        if(root == null){
            return;
        }
        get(root.left , list);
        get(root.right , list);
        list.add(root.data);
    }
    public static ArrayList<Integer> postOrder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        get(root , list);
        return list;
    }
    public static void main(String[] args) {
        String arr[] = {"19" , "10" , "8" , "11" , "13"};
        Node root = createNode(arr);
        ArrayList<Integer> ans = postOrder(root);
        System.out.println(ans);
        
    }
}
