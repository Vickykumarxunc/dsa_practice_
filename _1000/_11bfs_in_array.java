package _1000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;


public class _11bfs_in_array {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph , int v){
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.remove();
            list.add(node);
            for(int neighbour : graph.get(node)){
                if(visited[neighbour] == false){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
