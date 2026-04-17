package _1000;
import java.util.ArrayList;

public class _198preorder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> preorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        find(root , list);
        return list;
    }
    public static void find(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);
        find(root.left , list);
        find(root.right , list);
    }
    public static void main(String[] args) {
        
    }
}
