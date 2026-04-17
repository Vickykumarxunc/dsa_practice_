package _1000;
import java.util.Queue;
import java.util.LinkedList;

public class _247bottom_left_most_node {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int bottom_most(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int ans = -1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n; i++){
                Node temp = q.remove();
                if(i == 0){
                    ans = temp.data;
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
