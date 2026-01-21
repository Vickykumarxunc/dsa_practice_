
import java.util.ArrayList;

public class _8indegree_and_outdegree_for_each_vertex {
    public static ArrayList<ArrayList<Integer>> degree(int edges[][] , int V){

        // create a list : 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<V; i++){
            list.add(new ArrayList<>());
        }
        // create a indegree and outdegeree array : 
        int indegree[] = new int[V];
        int outdegree[] = new int[V];

        // traverse the edge : 
        for(int i = 0; i<edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            indegree[v]++;
            outdegree[u]++;
        }
        for(int i = 0; i<V; i++){
            list.get(i).add(indegree[i]);
            list.get(i).add(outdegree[i]);
        }
        return list;
    }
    public static void print(ArrayList<ArrayList<Integer>> list){
        for(int i = 0; i<list.size(); i++){
            System.out.println("indegree of " + i + " = " + list.get(i).get(0));
            System.out.println("outdegree of " + i + " = " + list.get(i).get(1));
        }
    }
    public static void main(String[] args) {
        int v = 4;
        int edges[][] = {
            {0 , 1},
            {0 , 3},
            {1 , 0},
            {2 , 0},
            {3 , 0},
            {3 , 2}
        };

        ArrayList<ArrayList<Integer>> list = degree(edges, v);
        System.out.println(list);
    }
}
