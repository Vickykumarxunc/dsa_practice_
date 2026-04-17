package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _208kahn_algorithm {
    public static int[] topoSort(ArrayList<ArrayList<Integer>> list , int v){
        
        // find indegree of each node : 
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        // push the node in the queue having zero indegree : 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int topo_sort[] = new int[v];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo_sort[i++] = node;

            //  break the link by decreasing the indegree : 
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return topo_sort;
    }
    public static void main(String args[]){

    }
}
