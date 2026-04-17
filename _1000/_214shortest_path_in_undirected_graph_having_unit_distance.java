package _1000;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class pair{
    int node;
    int dist;
    pair(int node , int dist){
        this.node = node;
        this.dist = dist;
    }
}
public class _214shortest_path_in_undirected_graph_having_unit_distance {

    // with unit distance weight or equal weight bfs always maintain the shortest path : 
    public static int[] shortest_path (int edges[][]){
        // create a graph :
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        // now apply the simple bfs : : : : : : : : : : : 
        Queue<Integer> q = new LinkedList<>();
        int distance[] = new int[n];
        for(int i = 0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        q.add(0);
        while(!q.isEmpty()){
             int node = q.remove();

            for(int neighbour : list.get(node)){
                if(distance[node] + 1 < distance[neighbour]){
                    distance[neighbour] = distance[node] + 1;
                    q.add(neighbour);
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        
    }
}
