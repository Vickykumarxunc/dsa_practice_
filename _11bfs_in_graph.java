import java.util.*;
public class _11bfs_in_graph {
    public static void add_edge(ArrayList<ArrayList<Integer>> graph , int u , int v){
        graph.get(v).add(u);
        graph.get(u).add(v);
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph , int start , int v){

        // create a list to store the ans : 
        ArrayList<Integer> list = new ArrayList<>();

        //create a queue : and visited array : 
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v + 1];

        // add the start node in the queue : 
        q.add(start);
        visited[start] = true;

        // now travese the graph : 
        while(!q.isEmpty()){

            // pop the element from the queue : 
            int node = q.remove();
            list.add(node);

            // now access the neighbour node of the current node : 
            for(int neighbour : graph.get(node)){
                if(visited[neighbour] == false){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return list;  
    }
    public static void print(ArrayList<ArrayList<Integer>> list){
        for(int i = 0; i<list.size(); i++){
            System.out.print(i + "->");
            for(int element : list.get(i)){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = 5;
        for(int i = 0; i<=v; i++){
             ArrayList<Integer> list = new ArrayList<>();
             graph.add(list);
        }
        add_edge(graph , 0 , 2);
        add_edge(graph , 0 , 1);
        add_edge(graph , 0 , 3);
        add_edge(graph , 2 , 4);

        System.out.println("adjacency list : ");
        print(graph);

        System.out.println("bfs traversal  : ");
        ArrayList<Integer> ans = bfs(graph, 0, v);
        System.out.println(ans);
    }
}
