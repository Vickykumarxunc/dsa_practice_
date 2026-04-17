import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class _0pratice {
    public static ArrayList<Integer> topoSort_dfs(ArrayList<ArrayList<Integer>> adj , int v){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(visited[i] == false){
                dfs(adj , st , visited , i);
            }
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> list , Stack<Integer> st , boolean visited[] , int node){
        visited[node] = true;
        for(int neighbour : list.get(node)){
            if(visited[neighbour] == false){
                dfs(list , st , visited , neighbour);
            }
        }
        st.push(node);
    }
    public static int[] kahn_algorithm(ArrayList<ArrayList<Integer>> list , int v){
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        int topo_order[] = new int[v];
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            topo_order[j++] = node;
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return topo_order;
    }
    public static boolean detect_cycle_using_bfs(ArrayList<ArrayList<Integer>> list , int v){
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int topo_size = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo_size++;
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return topo_size != v;
    }
    public static boolean ispossible(int v , int prerequisist[][]){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<v; i++){
            list.get(prerequisist[i][0]).add(prerequisist[i][1]);
        }
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int topo_size = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo_size++;
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return topo_size == v;
    }
    public static ArrayList<Integer> course_scheduling(ArrayList<ArrayList<Integer>> graph , int v){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<v; i++){
            adj.get(graph.get(i).get(1)).add(graph.get(i).get(0));
        }
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : adj.get(i)){
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
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if(list.size() != v){
            return new ArrayList<>();
        }
        return list;
    }
    public static ArrayList<Integer> find_eventually_safe_state(ArrayList<ArrayList<Integer>> adj , int v){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour  : adj.get(i)){
                list.get(neighbour).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safe = new ArrayList<>();
        for(int i = 0; i <v; i++){
            if(indegree[i]== 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            safe.add(node);
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return safe;
    }
    public static void main(String[] args) {

    }
}