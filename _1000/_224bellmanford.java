package _1000;
import java.util.ArrayList;
public class _224bellmanford{
    // time complexity = O(v * e)
    // for complete garph = O(v^3)
    public static int[] bellmanford_algorithm(ArrayList<ArrayList<Integer>> list , int V , int src){

        // create a distance array : 
        int distance[] = new int[V];

        // initially mark to infinity : 
        for(int i = 0; i<V; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        // do the n - 1 iteration : 
        for(int i = 0; i<V- 1; i++){
            for(ArrayList<Integer> edge : list){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]){
                    distance[v] = w + distance[u];
                }
            }
        }
        // agar n-1 iteration ke baad bhi relaxation possible hai 
        // negative cycle present hai : 
        for(ArrayList<Integer> edge : list){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]){
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        
    }
}