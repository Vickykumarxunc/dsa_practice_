package _1000;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class _191find_eventually_safe{
    
    // find eventaully safe state using the dfs : 
    public static ArrayList<Integer> safe_state_dfs(ArrayList<ArrayList<Integer>> graph , int v){
        boolean visited[] = new boolean[v];
        boolean pathvisited[] = new boolean[v];
        boolean check[] = new boolean[v];

        for(int i = 0; i<v; i++){
            if(visited[i] == false){
                dfs(graph , visited , pathvisited , check , i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i= 0; i<v; i++){
            if(check[i] == true){
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph , boolean visited[] , boolean pathvisited[] , boolean check[] , int node){
        visited[node] = true;
        pathvisited[node] = true;

        for(int neighbour : graph.get(node)){
            if(visited[neighbour] == false){
                if(dfs(graph , visited , pathvisited , check , neighbour) == true){
                    return true;
                }
            }
            if(pathvisited[neighbour] == true){
                return true;
            }
        }
        pathvisited[node] = false;
        check[node] = true;
        return false;
    }
    // find eventaully safe state using the bfs : :  : : 
    public static ArrayList<Integer> safe_state_bfs(ArrayList<ArrayList<Integer>> adj , int v){
        
        // first reverse the graph : 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            // i -> it
            // it -> i
            for(int neighbour : adj.get(i)){
                graph.get(neighbour).add(i);
                indegree[i]++;
            }
        }
        // apply the topoSort : 
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safe_node = new ArrayList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            safe_node.add(node);
            for(int neighbour : graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        Collections.sort(safe_node);
        return safe_node;
    }

    public static void main(String[] args) {
        
    }
}
