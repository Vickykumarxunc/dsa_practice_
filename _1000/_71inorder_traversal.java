package _1000;
import java.util.ArrayList;

public class _71inorder_traversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void find_inorder(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        find_inorder(root.left , list);
        list.add(root.data);
        find_inorder(root.right , list);
    }
    public static ArrayList<Integer> inorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        find_inorder(root , list);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
