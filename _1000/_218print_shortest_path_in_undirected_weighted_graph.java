package _1000;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

public class _218print_shortest_path_in_undirected_weighted_graph {
    public static class Pair{
        int node;
        int dist;
        Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    // time complexity = O(elogv) : : : : : : : : : 
    public static ArrayList<Integer> shortestPath(int edges[][] , int n , int m){

        // first create a graph ; 
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1] , edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0] , edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y)-> x.dist - y.dist);
        int distance[] = new int[n + 1];
        
        // create a memorization array ; 
        int parent[] = new int[n + 1];
        for(int i = 1; i<=n; i++){
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        distance[1] = 0;
        pq.add(new Pair(1 , 0));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();

            for(Pair item : adj.get(node)){
                int adjNode = item.node;
                int edgeWeight = item.dist;
                
                if(dist + edgeWeight < distance[adjNode]){
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new Pair(adjNode , dist + edgeWeight));

                    // remember the node : : 
                    parent[adjNode] = node;
                }
            }
        }

        // now create a ans array : : 
        ArrayList<Integer> path = new ArrayList<>();
        // not reachable : 
        if(distance[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        // source node : 
        path.add(1);
        Collections.reverse(path); // reverse the node : 
        return path;
    }
    public static void main(String[] args) {
        
    }
}
