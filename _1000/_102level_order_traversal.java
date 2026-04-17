package _1000;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _102level_order_traversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> traverse(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            list.add(temp.data);
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
