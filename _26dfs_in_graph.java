import java.util.*;
public class _26dfs_in_graph {
    public static void add_edges(ArrayList<ArrayList<Integer>> graph , int u , int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    public static void find(ArrayList<ArrayList<Integer>> graph , ArrayList<Integer> list , boolean visited[] , int node){

        // marking current node as visited : 
        visited[node] = true;
        list.add(node);

         // getting neighbour node : 
        for(int neighbour : graph.get(node)){

            // recursion for each unvisited node : 
            if(visited[neighbour] == false){
                find(graph , list , visited , neighbour);
            }
        }
    }
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> graph , int start , int n){

        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[n + 1];
        find(graph , ans , visited , 0);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = 4;
        for(int i = 0; i<=v; i++){
            ArrayList<Integer> list = new ArrayList<>();
            graph.add(list);
       }
        add_edges(graph , 0 , 2);
        add_edges(graph , 0 , 3);
        add_edges(graph , 0 , 1);
        add_edges(graph , 2 , 4);

        ArrayList<Integer> ans = dfs(graph , 0 , v);
        System.out.println(ans);
    }
}
