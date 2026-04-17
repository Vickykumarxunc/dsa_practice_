import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class _221cheapest_flight_with_k_stop{
    public static class triplet{
        int stop;
        int node;
        int dist;
        triplet(int stop , int node , int dist){
            this.stop = stop;
            this.node = node;
            this.dist = dist;
        }
    }
    public static class pair{
        int node;
        int dist;
        pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static int cheapestfligth(int flight[][] , int n , int src , int dst , int k){

        // first create a directed graph u->v with distance : 
        ArrayList<ArrayList<pair>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            list.get(flight[i][0]).add(new pair(flight[i][1] , flight[i][2]));
        }
        // create a simple queue 
        // put the source node into the queue with zero stop and zero distance : 
        Queue<triplet> q = new LinkedList<>();
        q.add(new triplet(0 , src , 0));

        // create a distance array initially mark as infinity : 
        int distance[] = new int[n];
        for(int i = 0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        // distance of the source node is zero : 
        distance[0] = 0;

        // hum stop ke basis par node ko pop karaege queue me se : 
        while(!q.isEmpty()){

            // pop the node one by one : 
            int stop = q.peek().stop;
            int node = q.peek().node;
            int dist = q.peek().dist;

            // agar stop given stop (k) se jyada ho jaye to kuch mat kare : 
            if(stop > k){
                continue;
            }
            // now traverse the neighbour node ;
            for(pair neighbour : list.get(node)){
                int adjnode = neighbour.node;
                int weight = neighbour.dist;

                if(dist + weight < distance[adjnode] && stop <= k){
                    distance[adjnode] = dist + weight;
                    q.add(new triplet(stop + 1 , adjnode , weight + dist));
                }
            }
        }
        // not possible to reach destination within k stop : 
        if(distance[dst] == Integer.MAX_VALUE){
            return -1;
        }
        // if possible return distance : 
        return distance[dst];
    }
    public static void main(String[] args) {
        
    }
}