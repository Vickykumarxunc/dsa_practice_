package _1000;
import java.util.ArrayList;

public class _106postorder_traversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> postorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        find(root , list);
        return list;
    }
    public static void find(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        find(root.left , list);
        find(root.right , list);
        list.add(root.data);
    }
    public static void main(String[] args) {
        
    }
}
