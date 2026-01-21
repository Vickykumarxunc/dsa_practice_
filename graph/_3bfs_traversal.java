

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _3bfs_traversal {
    public static void add_edges(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v); // u->v;
        list.get(v).add(u); // v->u;
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list , int V){

        // create a array list which store the bfs traversal : 
        ArrayList<Integer> ans = new ArrayList<>();

        // create a queue for the bfs : 
        Queue<Integer> q = new LinkedList<>();

        // create a visited array : 
        boolean visited[] = new boolean[V + 1];

        // starting node is the 0 : 
        q.add(1);
        visited[1] = true;

        // now traverse the graph : 
        while(!q.isEmpty()){

            int node = q.remove();
            // add into the list : 
            ans.add(node);

            // add the neighbour node of the current node : 
            for(int neighbour : list.get(node)){

                // agar neighbour unvisited hai to use queue me add karo :
                if(visited[neighbour] == false){
                    
                    // first marks as visited : 
                    visited[neighbour] = true;

                    // now add into the queue : 
                    q.add(neighbour);
                }
            }
        }
        // return the ans : 
        return ans;
    }
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 5;
        for(int i = 0; i<=v; i++){
            list.add(new ArrayList<>());
        }
        add_edges(list , 1 , 2);
        add_edges(list , 1 , 3);
        add_edges(list , 2 , 4);
        add_edges(list , 3 , 4);
        add_edges(list , 4 , 5);

        ArrayList<Integer> ans = bfs(list , v);
        System.out.println(ans);

    }
}
/*
time complexity  : O(v + 2e)
space complexity : O(V + e)
 */
