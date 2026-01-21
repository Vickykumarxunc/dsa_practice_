import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class _100reverse_level_order_traversal {
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
    public static ArrayList<Integer> reverseLevelOrder(Node root){

        ArrayList<Integer> list = new ArrayList<>();
        
        // base condtion : 
        if(root == null){
            return list;
        }
        // apply the bfs from right to left : 
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.remove();
            list.add(temp.data);

            if(temp.right != null){
                q.add(temp.right);
            }
            if(temp.left != null){
                q.add(temp.left);
            }
        }
        // now reverse the list : 
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        String arr[] = {"10" , "20" , "30" , "40" , "60" , " "};
        Node root = createNode(arr);

        ArrayList<Integer> ans = reverseLevelOrder(root);
        System.out.println(ans);
        
    }
}
