package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _9left_view_of_binary_tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    // using dfs : 
    public static ArrayList<Integer> left_view_using_dfs(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        int max[] = new int[]{0};
        find1(root , list , max , 1);
        return list;
    }
    public static void find1(Node root , ArrayList<Integer> list , int max[] ,int level){
        if(root == null){
            return;
        }
        if(max[0] < level){
            list.add(root.data);
            max[0] = level;
        }
        find1(root.left , list , max , level + 1);
        find1(root.right , list , max , level + 1);
    }
    // using bfs : 
    public static ArrayList<Integer> lefe_view_using_bfs(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = 0;
            for(int i = 0; i<size; i++){
                Node node = q.remove();
                if(i == 0){
                    list.add(node.data);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        
    }
}
