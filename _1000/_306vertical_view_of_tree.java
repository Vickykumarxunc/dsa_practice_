package _1000;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;
public class _306vertical_view_of_tree{
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
    //* main logic => same horizontal distance wale node ek sath :  */
    // O(nlogn)
    public static ArrayList<ArrayList<Integer>> vertical_view(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeMap<Integer , ArrayList<Integer>> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root , 0));
        
        while(!q.isEmpty()){
            pair curr = q.remove();
            Node node = curr.node;
            int hd = curr.hd;

            if(!map.containsKey(hd)){
                ArrayList<Integer> temp = new ArrayList<>();
                map.put(hd , temp);
            }
            map.get(hd).add(node.data);

            if(node.left != null){
                q.add(new pair(node.left , hd - 1));
            }
            if(node.right != null){
                q.add(new pair(node.right , hd + 1));
            }
        }
        for(ArrayList<Integer> list : map.values()){
            ans.add(list);
        }
        return ans;
    }
    public static void main(String args[]){

    }
}