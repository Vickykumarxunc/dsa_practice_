package _1000;
import java.util.ArrayList;

public class _289binary_tree_path {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void find(Node root , ArrayList<String> ans , String path){
        if(root == null){
            return;
        }
        if(path.length() == 0){
            path = path + root.data;
        }
        else{
            path = path + "->" + root.data;
        }
        // if we reach leaf node : 
        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }
        // preorder : 
        find(root.left , ans , path);
        find(root.right , ans , path);
    }
    public static ArrayList<String> path(Node root){
        ArrayList<String> ans = new ArrayList<>();
        find(root , ans , "");
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
