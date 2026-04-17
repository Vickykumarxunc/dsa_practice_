package _1000;
import java.util.ArrayList;

public class _77node_without_sibling {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> node_without_sibling(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        get_node(root , list);
        return list;
    }
    public static void get_node(Node root , ArrayList<Integer> list){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.left == null && root.right != null){
            list.add(root.right.data);
        }
        if(root.right == null && root.left != null){
            list.add(root.left.data);
        }
        get_node(root.left , list);
        get_node(root.right , list);
    }
    public static void main(String[] args) {
        
    }
}
