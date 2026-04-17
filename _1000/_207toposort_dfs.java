package _1000;
import java.util.ArrayList;
import java.util.Stack;

public class _207toposort_dfs {
    public static void dfs(ArrayList<ArrayList<Integer>> graph , boolean visited[] , Stack<Integer> st , int node){
        visited[node] = true;
        // node ke depth me jate jao : 
        for(int neighbour : graph.get(node)){
            if(visited[neighbour] == false){
                dfs(graph , visited , st , neighbour);
            }
        }
        // agar koi function call nahi hai to use push kar do stack me . 
        st.push(node);
    }
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> graph , int v){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(visited[i] == false){
                dfs(graph , visited , st , i);
            }
        }
        // stack contain the at least one topsort order : 
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
