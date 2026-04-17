package _1000;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

///
/// tree ko uper se dekhne par node node visible ho wahi top view hai : 
/// result store from left to right : 
///* */ here concept of the horizontal distance => 
/// hum har node ke liye horizontal distnace assign karege ; 
/// root => HD = 0
/// left child => HD = parent_hd - 1
/// right child => HD = parent_hd + 1 
/// * har HD ke liye pehle node lo bfs order : 
/// map use karo jiske ander hum har horizontal distance ka first node rakhege sorted order me : 
/// agar HD map me already present hai to skip karo , 
/// agar HD mpa me present nahi hai to add karo : 
public class _304top_view_of_binary_tree {
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
    public static ArrayList<Integer> top_view(Node root){
        TreeMap<Integer , Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root , 0));
         
        while(!q.isEmpty()){
            pair curr = q.remove();
            Node node = curr.node;
            int hd = curr.hd;

            // store only first node of each horizontal distance : 
            if(!map.containsKey(hd)){
                map.put(hd , node.data);
            }
            // ab curr node left node node push karo : 
            if(node.left != null){
                q.add(new pair(node.left , hd - 1));
            }
            // ab curr node ke right node push karo : 
            if(node.right != null){
                q.add(new pair(node.right  , hd + 1));
            }
        }
        // now create a answer : 
        ArrayList<Integer> ans = new ArrayList<>();
        for(int value : map.values()){
            ans.add(value);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
