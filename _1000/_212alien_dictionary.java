package _1000;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _212alien_dictionary {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> graph , int v){
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            list.add(node);
            for(int neighbour : graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return list;

    }
    public static String findOrder(String dict[] , int n , int k){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<k; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<n -1; i++){
            String s1 = dict[i];
            String s2 = dict[i + 1];

            // s1 -> s2
            int length = Math.min(s1.length() , s2.length());
            for(int j = 0; j<length; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    list.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo  = topoSort(list, k);
        StringBuilder ans = new StringBuilder();
        for(int i : topo){
            ans.append(i);
        }
        return new String(ans);
    }
    public static void main(String[] args) {
        
    }
}
