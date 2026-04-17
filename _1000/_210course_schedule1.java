package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _210course_schedule1 {
    public static boolean isPoosible(int prerequisites[][] , int v){

        // first create a graph 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // now calculate the indegree of each node : 
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }
        // add the node in the queue which have a indegree is zero : 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int topo_sort = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo_sort++;
            for(int neighbour : graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        // if not cycle present then possible else not possible : 
        return topo_sort == v;
    }
    public static void main(String[] args) {
        
    }
}
