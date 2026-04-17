package _1000;
import java.util.Queue;
import java.util.LinkedList;

public class _287cousion_in_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static class pair{
        Node node;
        Node parent;
        pair(Node node , Node parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static boolean coursin(Node root , int x , int y){

        // use the queue and track the parent of each node : 
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root , null));

        while(!q.isEmpty()){
            
            // at time ek level ko treat karo : 
            int n = q.size();
            Node parent_x = null;
            Node parent_y = null;

            for(int i = 0; i<n; i++){
                pair curr = q.remove();

                // parent of x : 
                if(curr.node.data == x){
                    parent_x = curr.parent;
                }
                // parent of y : 
                if(curr.node.data == y){
                    parent_y = curr.parent;
                }
                // push the left right value of current node if exist : 
                if(curr.node.left != null){
                    q.add(new pair(curr.node.left , curr.node));
                }
                if(curr.node.right != null){
                    q.add(new pair(curr.node.right , curr.node));
                }
            }
            // agar ek level ke baad check karo 
            if(parent_x != null && parent_y != null){
                return parent_x != parent_y; // cousion have different parent but at same level : 
            }
            // is any one is not present at same level : 
            if(parent_x != null || parent_y != null){
                return false;
            }
        }
        return false; // if not cousion : 
    }
    public static void main(String[] args) {
        
    }
}
