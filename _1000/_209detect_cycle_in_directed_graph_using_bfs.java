package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _209detect_cycle_in_directed_graph_using_bfs {
    public static boolean detect_cycle(ArrayList<ArrayList<Integer>> list , int v){
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        int topo_sort = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            topo_sort++;
            for(int neighbour :  list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return topo_sort != v;
    }
    public static void main(String[] args) {
        
    }
}
