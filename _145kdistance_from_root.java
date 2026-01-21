import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class _145kdistance_from_root {
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
    // using the bfs : 
    // time = O(n) // space = O(widht of tree) worst = O(n)
    public static ArrayList<Integer> node_of_kth_level(Node root , int k){

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        // add the root node in the queue : 
        q.add(root);
        int level = 0;

        while(!q.isEmpty()){

            int size = q.size();

            // queue ke ander ek time par ek level ke saare node present hote hai ; 
            if(level == k){
                while(!q.isEmpty()){
                    list.add(q.remove().data);
                }
                break;
            }
            for(int i = 0; i<size; i++){
                Node curr = q.remove();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            // increase the level by one : 
            level++;
        }
        return list;
    }
    // using the dfs : 
    // time = O(n) // space = O(hight) 
    public static ArrayList<Integer> kth_level_node(Node root , int k){
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root , k , 0 , list);
        return list;
    }
    public static void dfs(Node root , int k , int level , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(k == level){
            list.add(root.data);
            return; // kth level se aage jane ki jarurat nahi hai : 
        }
        dfs(root.left , k , level + 1 , list);
        dfs(root.right , k , level + 1 , list);
    }
   public static void main(String[] args) {
    String arr[] = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , " "};
    Node root = createNode(arr, arr.length);
    int k = 1;
    ArrayList<Integer> ans = node_of_kth_level(root, k);
    System.out.println(ans);
   } 
}
