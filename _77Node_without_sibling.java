
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class _77Node_without_sibling{
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
    // method 1 : using the dfs : 
    public static ArrayList<Integer> noSibling(Node root){

        ArrayList<Integer> list = new ArrayList<>();
        getSibling(root , list);

        Collections.sort(list);
        
        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }
    public static void getSibling(Node root , ArrayList<Integer> list){

        // base condition : 
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.left == null){
            list.add(root.right.data);
        }
        if(root.right == null){
            list.add(root.left.data);
        }
        getSibling(root.left , list);
        getSibling(root.right , list);
    }
    // method 2 using bfs : 
    public static ArrayList<Integer> noSibling_bfs(Node root){

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            // pick the node from the queue : 
            Node curr = q.remove();

            // agar left node present ho : 
            if(curr.right == null && curr.left != null){
                list.add(curr.left.data);
            }
            // agar right node present ho : 
            if(curr.left == null && curr.right != null){
                list.add(curr.right.data);
            }
            // ap queue me node add karo : 
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        // agar bina sibling ka node present nahi hai : 
        if(list.isEmpty()){
            list.add(-1);
        }
        else{
            Collections.sort(list);
        }
        return list;
    }
    public static void main(String args[]){
        String arr[] = {"37" , "20" , " " , "113" , " "};
        Node root = createNode(arr);

        ArrayList<Integer> ans = noSibling(root);
        System.out.println(ans);

    }
}