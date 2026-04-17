package _1000;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class _307diagonal_tree_traversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static class pair{
        Node node;
        int hd;
        pair(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static ArrayList<ArrayList<Integer>> diagonal_traversal(Node root){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        TreeMap<Integer , ArrayList<Integer>> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();

        q.add(new pair(root , 0));

        // jab hum left side me jayege to node ko unique number assing karege 
        // jab hum right side me jayege to node ke right ko same number dege kyoki vo diagonal ka hissa hai : 
        while(!q.isEmpty()){
            pair curr = q.remove();
            Node node = curr.node;
            int hd = curr.hd;

            if(!map.containsKey(hd)){
                ArrayList<Integer> temp = new ArrayList<>();
                map.put(hd , temp);
            }
            map.get(hd).add(node.data);

            // go left is exist : 
            if(node.left != null){
                q.add(new pair(node.left , hd + 1));
            }
            // go right if exist : 
            if(node.right != null){
                q.add(new pair(node.right , hd));
            }
        }
        // create ans : 
        for(ArrayList<Integer> value : map.values()){
            list.add(value);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
