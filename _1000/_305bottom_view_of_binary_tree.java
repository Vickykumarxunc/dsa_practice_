package _1000;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;

public class _305bottom_view_of_binary_tree {
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
    // har horizontal distance ka last node : 
    public static ArrayList<Integer> bottom_view(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer , Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root , 0));

        while(!q.isEmpty()){
            pair curr = q.remove();
            Node node = curr.node;
            int hd = curr.hd;

            // har horizontal distance ka last node : 
            map.put(hd , node.data);

            // curr node ka left : 
            if(node.left != null){
                q.add(new pair(node.left , hd - 1));
            }
            // curr node ka right : 
            if(node.right != null){
                q.add(new pair(node.right , hd + 1));
            }
        }
        for(int value : map.values()){
            list.add(value);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
