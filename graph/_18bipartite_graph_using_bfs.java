import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class _18bipartite_graph_using_bfs {

    public static boolean isbipartite(ArrayList<ArrayList<Integer>> list , int v){

        // create a visited array initialize with -1 : 
        int color[] = new int[v];
        for(int i = 0; i<v; i++){
            color[i] = -1;
        }
        for(int i = 0; i<v; i++){
            if(color[i] == -1){
                if(check(list , color , i) == false){
                    return false;
                }
            }
        }
        return true;
    }

    // using the bfs : : 
    public static boolean check(ArrayList<ArrayList<Integer>> list , int color[] , int start){

        // create a queue : 
        Queue<Integer> q = new LinkedList<>();
        // mark the starting node color :
        color[start] = 0; 
        // add into the queue : 
        q.add(start);

        // taverse the queue : 
        while(!q.isEmpty()){

            int node = q.remove();

            // traverse the neighbour and color it : 
            for(int neighbour : list.get(node)){

                // if the adjacency node it yet not colored 
                // you will give the opposite color of node : 
                if(color[neighbour] == -1){
                    color[neighbour] = 1 - color[node];
                    q.add(neighbour);
                }
                // if the adjacency node have the same color 
                // someone did color it on some other path : 
                else if(color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void add_edge(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 6;
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edge(list , 0 , 1);
        add_edge(list , 1 , 2);
        add_edge(list , 1 , 4);
        add_edge(list , 2 , 3);
        add_edge(list , 4 , 3);
        add_edge(list , 3 , 5);

        boolean ans = isbipartite(list, v);
        System.out.println("graph is bipartite or not = " + ans);
        
    }
}

/*
bipartite graph = > color of the graph with 2 color such that no adjacent nodes have same color :
. even length cycl always a bipartite graph : 
. odd length cycle can never be a bipartite graph : 
. linear graph with no cycye always bipartite graph :  
 */