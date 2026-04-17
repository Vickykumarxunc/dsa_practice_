package _1000;
import java.util.ArrayList;
public class _180number_of_proviences {
    public static int number_of_proviences(ArrayList<ArrayList<Integer>> graph , int v){
        boolean visited[] = new boolean[v];
        int count = 0;
        for(int i = 0; i<v; i++){
            if(visited[i] == false){
                count++;
                mark_proviences(graph , visited , i);
            }
        }
        return count;
    }
    public static void mark_proviences(ArrayList<ArrayList<Integer>> graph , boolean visited[] , int node){
        visited[node] = true;
        for(int neighbour : graph.get(node)){
            if(visited[neighbour] == false){
                mark_proviences(graph , visited , neighbour);
            }
        }
    }
    public static void main(String args[]){

    }
}
