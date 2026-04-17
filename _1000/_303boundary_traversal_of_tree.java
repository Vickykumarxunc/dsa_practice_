package _1000;
import java.util.ArrayList;

public class _303boundary_traversal_of_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void left(Node root , ArrayList<Integer> list){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        list.add(root.data);
        
        if(root.left != null){
            left(root.left , list);
        }
        else{
            left(root.right , list);
        }
    }
    public static void leaf(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        leaf(root.left , list);
        if(root.left == null && root.right == null){
            list.add(root.data);
        }
        leaf(root.right , list);
    }
    public static void right(Node root , ArrayList<Integer> list){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.right != null){
            right(root.right , list);
        }
        else{
            right(root.left , list);
        }
        list.add(root.data);
    }
    public static ArrayList<Integer> boundary_travesal(Node root){
        ArrayList<Integer> list = new ArrayList<>();

        // agar tree null hai return empty list : 
        if(root == null){
            return list;
        }
        // first add the root node :
        list.add(root.data);
        
        // now add the left side node : 
        left(root.left , list);

        // add the leaf node of left subtree : 
        leaf(root.left , list);

        // add the leaf of right subtree : 
        leaf(root.right , list);

        // add the right side node in reverse order : 
        right(root.right , list);

        return list;
    }

    public static void main(String args[]){

    }
}
