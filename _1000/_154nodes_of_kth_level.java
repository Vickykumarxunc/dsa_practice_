package _1000;
import  java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _154nodes_of_kth_level {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> kth_level_node(Node root , int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n; i++){
                Node node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            k--;
            if(k == 0){
                while(!q.isEmpty()){
                    list.add(q.remove().data);
                }
                return list;
            } 
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
