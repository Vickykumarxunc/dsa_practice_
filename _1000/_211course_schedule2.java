package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _211course_schedule2 {
    public static int[] course_schedule2(ArrayList<ArrayList<Integer>> prerequisist , int v){

        // form a graph only reverse the edge : 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<v; i++){
            list.get(prerequisist.get(i).get(1)).add(prerequisist.get(i).get(0));
        }
        // calculate the indegree : 
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        // add the node in queue which having the indegree zero : 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // return any one order : 
        int topo_sort[] = new int[v];
        int i  = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo_sort[i++] = node;

            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        // if order possible return order : 
        if(topo_sort.length == v){
            return topo_sort;
        }
        int arr[]  = {};
        return arr;
    }
    public static void main(String[] args) {
        
    }
}
