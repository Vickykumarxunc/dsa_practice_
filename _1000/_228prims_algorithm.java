package _1000;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class _228prims_algorithm {
    public static class pair{
        int node;
        int parent;
        pair(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static class triplet{
        int node;
        int parent;
        int weight;
        triplet(int node  , int parent , int weight){
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
    }
    public static ArrayList<pair> prims_algorithm(ArrayList<ArrayList<ArrayList<Integer>>> adj , int v){

        // create min heap : 
        PriorityQueue<triplet> pq = new PriorityQueue<>();

        // create a visited array : 
        boolean visited[] = new boolean[v];

        // create a list which store the edge of mst : 
        ArrayList<pair> mst = new ArrayList<>();

        // cost of the mst : 
        int cost = 0;

        // add the source node in the heap with parent zero :
        pq.add(new triplet(0 , -1 , 0));
        visited[0] = true;

        while(!pq.isEmpty()){

            // pop the one by node from the priority queue : 
            int node = pq.peek().node;
            int weight = pq.peek().weight;
            int parent = pq.peek().parent;

            // agar node un visited hai to use hum mst me add kar de ge 
            // aur mark as visited 
            if(visited[node] == false){
                mst.add(new pair(node , parent));
                visited[node] = true;
                cost += weight;
            }
            // agar node visited hai to kuch mat kare : 
            if(visited[node] == true){
                continue;
            }
            // now traverse the neighbour of node : 
            for(int i = 0; i<adj.get(node).size(); i++){
                int adjnode = adj.get(node).get(i).get(0);
                int edweight = adj.get(node).get(i).get(1);

                // agar unvisited hai to add into the pririty : 
                if(visited[adjnode] == false){
                    pq.add(new triplet(adjnode , node , edweight));
                }
            }
        }
        System.out.println("cost of the mst = " + cost);
        return mst;
    }

    public static void main(String args[]){

    }
}
