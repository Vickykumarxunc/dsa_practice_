package _1000;
import java.util.ArrayList;
import java.util.Stack;

// kosaraju's algorithm 
public class _237strongly_connected_component {

    // dfs for fininshing time : 
    public static void dfs(ArrayList<ArrayList<Integer>> adj , boolean visited[] , Stack<Integer> st , int node){
        
        // mark as visited : 
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(visited[neighbour] == false){
                dfs(adj , visited , st , neighbour);
            }
        }
        // backtrack 
        // store based on the finishing time 
        st.push(node);
    }
    // dfs on reversed graph to find scc : 
    public static void mark_scc(ArrayList<ArrayList<Integer>> adj , boolean visited[] , ArrayList<Integer> temp , int node){
        temp.add(node);
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(visited[node] == false){
                mark_scc(adj , visited , temp , neighbour);
            }
        }
    }
     public static ArrayList<ArrayList<Integer>> kosaraju(int v , int edges[][]){

        // create a directed graph : 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        // step 1 sort all the edges based on the finishing time : 
        boolean visited[] = new boolean[v];

        // used to stack to store the node based on the finishing time 
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<v; i++){
            if(visited[i] == false){
                dfs(adj , visited , st , i);
            }
        }

        // step 2 : reverse the graph : 
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i<v; i++){
            visited[i] = false;
            for(int neighbour : adj.get(i)){
                // i-> neighbour 
                // neighbour -> i
                rev.get(neighbour).add(i);
            }
        }

        // now apply the dfs based on the order of stack : 
        // count the strongly connected component : 
        int scc = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<v; i++){
            ans.add(new ArrayList<>());
        }
        while(!st.isEmpty()){

            // pop the element one by one : 
            int node = st.pop();
            if(visited[node] == false){

                ArrayList<Integer> temp = new ArrayList<>();

                // apply the dfs to mark the one connected componenet : 
                mark_scc(rev , visited , temp , node);
                ans.add(temp);
                scc++;
            }
        }
        System.out.println("number of strongly connected component = " + scc);
        return ans;
     }
    public static void main(String args[]){
        int v = 5;
        int edges[][] = {
            {0 , 1},
            {1 , 2},
            {2 , 0},
            {1 , 3},
            {3 , 4}
        };
        ArrayList<ArrayList<Integer>> result = kosaraju(v , edges);
        System.out.println(result);
    }
}
 