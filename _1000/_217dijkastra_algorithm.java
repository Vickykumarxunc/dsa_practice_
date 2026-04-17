package _1000;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

//Make visited array & mark them visited so that you don't forget
public class _217dijkastra_algorithm {
    public static class pair{
        int node;
        int dist;
        pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    // time complexity = ElogV : : : : : : : : : : : :
    // using the priority queue : : : : 
    public static int[] diskastra(ArrayList<ArrayList<ArrayList<Integer>>> list , int s , int v){

        // create a priority queue store the node based on the minimum distance : 
        PriorityQueue<pair> pq = new PriorityQueue<pair>((x , y)-> x.dist - y.dist);
        // mark as infinity initially :
        int distance[] = new int[v];
        for(int i = 0; i<v; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        // source node : 
        distance[s] = 0;
        pq.add(new pair(0 , s));

        // traverse the queue jab tak queue empty na ho : 
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();

            // traverse the adjacency node : 
            for(int i = 0; i<list.get(node).size(); i++){
                int edgeWeight = list.get(node).get(i).get(1);
                int adjNode = list.get(node).get(i).get(0);

                // update the distance : 
                if(dist + edgeWeight < distance[adjNode]){
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new pair(distance[adjNode] , adjNode));
                }
            }
        }
        return distance;
    }
    public static void main(String args[]){

    }
}
