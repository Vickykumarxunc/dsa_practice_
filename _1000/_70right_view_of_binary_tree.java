package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _70right_view_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
    }
    // har ek level ka last element : 
    public static ArrayList<Integer> right_view(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int n = q.size();

            for(int i = 0; i<n; i++){

                Node temp = q.remove();
                
                if(i == n - 1){
                    list.add(temp.data);
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
