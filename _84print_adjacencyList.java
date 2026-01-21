import java.util.ArrayList;

public class _84print_adjacencyList {
     
    public static ArrayList<ArrayList<Integer>> adjacencyList(int edges[][] , int V){

        // create a adjacency list : 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // initialize va empty list : 
        for(int i = 0; i<V; i++){
            ans.add(new ArrayList<>());
        }
        
        // add edges : 
        for(int i = 0; i<V; i++){

            int v = edges[i][0];
            int u = edges[i][1];

            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {
            {0 , 1},
            {0 , 2},
            {1, 2},
            {2 , 3}
        };


        ArrayList<ArrayList<Integer>> adj = adjacencyList(edges, V);
        System.out.println(adj);
    }
}
