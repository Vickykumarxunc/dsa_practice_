package _1000;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _223number_of_way_to_arrive_at_destination {
    public static class pair{
        int node;
        int dist;
        pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static int countPath(int n , ArrayList<ArrayList<Integer>> roads){

        // first create a undirected graph : 
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            adj.get(roads.get(i).get(0)).add(new pair(roads.get(i).get(1) , roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new pair(roads.get(i).get(0) , roads.get(i).get(2)));
        }
        // use the min heap priority queue : 
        PriorityQueue<pair> pq = new PriorityQueue<>((x , y)-> x.dist - y.dist);

        // create a distance array : 
        int distance[] = new int[n];

        
        // create array which store the number of way : 
        int way[] = new int[n];

        // intially marks as infinity :
        for(int i = 0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
            way[i] = 0;
        }

        // mark the source node : and add into the pq : 
        distance[0] = 0;
        way[0] = 1;

        pq.add(new pair(0 , 0));

        // traverse the queue : 
        while(!pq.isEmpty()){

            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();

            // traverse the neighbour : 
            for(pair neighbour : adj.get(node)){
                int adjnode = neighbour.node;
                int weight = neighbour.dist;

                // agar mai node ko phli baar visit kar raha hoon : 
                if(dist + weight < distance[adjnode]){
                    pq.add(new pair(adjnode , dist + weight));
                    distance[adjnode] = dist + weight;
                    way[adjnode] = way[node];
                }
                // agar mai node dusri baar visit kar raha hoon with same distance : 
                // mean this is the second way : 
                else if(dist + weight == distance[adjnode]){
                    way[adjnode] = (way[adjnode] + way[node]);
                }
            }
        }
        return way[n - 1];
    }
    public static void main(String args[]){

    }
}
