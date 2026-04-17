package _1000;
import java.util.ArrayList;
import java.util.Stack;

class pair{
    int node;
    int weight;
    pair(int node , int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class _213shortest_path_in_directed_graph_using_topo_sort {
    public static void topo_sort(ArrayList<ArrayList<pair>> list , boolean visited[] , Stack<Integer> st , int node){
        visited[node] = true;
        for(int i = 0; i<list.get(node).size(); i++){
            int v = list.get(node).get(i).node;
            if(visited[v] == false){
                topo_sort(list , visited , st , v);
            }
        }
        st.push(node);
    }
    public static int[] shortest_path(int edges[][]){
        int n = edges.length;
        int m = edges[0].length;

        // first create a graph : 
        ArrayList<ArrayList<pair>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            ArrayList<pair> temp = new ArrayList<>();
            list.add(temp);
        }
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            list.get(u).add(new pair(v , weight));
        }
        // step 1 : apply the topo sort on the above graph : 
        boolean visited[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(visited[i] == false){
                topo_sort(list , visited , st, i);
            }
        }
        // step 2 : take the node from the stack one by one 
        // and maintain the distance array with minimum distance  : 

        // initially all distance is infinity : 
        int dist[] = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        // source node is always zero : 
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();

            // neighbour of the node : 
            for(int i = 0; i<list.get(node).size(); i++){
                int v = list.get(node).get(i).node;
                int wt = list.get(node).get(i).weight;

                // reduce the distnace : 
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }  
        for(int i = 0; i<n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }     
        return dist;
    }
    public static void main(String[] args) {
        
    }
}