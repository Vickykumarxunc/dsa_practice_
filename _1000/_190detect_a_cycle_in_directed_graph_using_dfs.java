package _1000;
import java.util.ArrayList;

public class _190detect_a_cycle_in_directed_graph_using_dfs {
    public static boolean detect_cycle(ArrayList<ArrayList<Integer>> graph , int v){
        boolean visited[] = new boolean[v];
        boolean pathvisited[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(visited[i] == false){
                if(check(graph , visited , pathvisited , i) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean check(ArrayList<ArrayList<Integer>> graph , boolean visited[] , boolean pathvisited[] , int node){
        visited[node] = true;
        pathvisited[node] = true;
        for(int neighbour : graph.get(node)){
            if(visited[neighbour] == false){
                if(check(graph , visited , pathvisited , neighbour) == true){
                    return true;
                }
            }
            else if(pathvisited[neighbour] == true){
                return true;
            }
        }
        pathvisited[node] = false;
        return false;
    }
    public static void main(String[] args) {
        
    }
}
