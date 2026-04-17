package _1000;
import java.util.ArrayList;

public class _239articulation_point {
    public static void dfs(ArrayList<ArrayList<Integer>> adj , boolean visited[] , boolean mark[] , int tin[] , int low[] , int timer[] , int node , int parent){

        // first visit the node : 
        visited[node] = true;
        tin[node] = timer[0];
        low[node] = timer[0];
        timer[0]++;
        int child = 0;
        
        // go the neighbour : 
        for(int neighbour : adj.get(node)){
            if(neighbour == parent){
                continue;
            }
            if(visited[neighbour] == false){
                
                dfs(adj , visited , mark , tin , low , timer , neighbour , node);
                low[node] = Math.min(low[node] , low[neighbour]);

                // node --- neighbour : 
                if(low[neighbour] >= tin[node] && parent != -1){
                    mark[node] = true;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node] , tin[neighbour]);
            }
        }
        // for the starting node : 
        if(child > 1 && parent == -1){
            mark[node] = true;
        }
    }
    public static ArrayList<Integer> articulation_point(int n , ArrayList<ArrayList<Integer>> adj){

        // create a visited array ; 
        boolean visited[] = new boolean[n];
        
        // create a time of insertion array : 
        int tin[] = new int[n];

        // create a lower timer of insertion array : 
        int low[] = new int[n];

        // create a mark array which mark the articulation point : 
        boolean mark[] = new boolean[n];
        int timer[] = new int[]{1};

        for(int i = 0; i<n; i++){
            if(visited[i] == false){
                dfs(adj , visited , mark , tin , low , timer , i , -1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(mark[i] == true){
                ans.add(i);
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
