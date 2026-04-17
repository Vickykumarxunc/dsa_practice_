package _1000;
import java.util.ArrayList;

public class _26dfs_in_graph {
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> graph , int v){
        ArrayList<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[v];
        find(graph , visited , list , 0);
        return list;
    }
    public static void find(ArrayList<ArrayList<Integer>> graph , boolean visited[] , ArrayList<Integer> list , int node){
        visited[node] = true;
        list.add(node);
        for(int neighbour : graph.get(node)){
            if(visited[neighbour] == false){
               find(graph , visited , list , neighbour);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
