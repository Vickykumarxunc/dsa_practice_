import java.util.ArrayList;
import java.util.Stack;
public class _22topological_sort_using_dfs {

    public static ArrayList<Integer> topological_sort(ArrayList<ArrayList<Integer>> list , int v){

        // create a visited array ; 
        int visited[] = new int[v];

        // create a stack which store the element in topological sort : 
        Stack<Integer> st = new Stack<>();

        // graph can be disconnedted : 
        for(int i = 0; i<v; i++){

            if(visited[i] == 0){
                dfs(list , visited , st , i);
            }
        }
        // create a ans array List : 
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        // return the one of them topological sort : 
        return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> list , int visited[] , Stack<Integer> st , int node){

        // mark the current node : 
        visited[node] = 1;

        // visited the neighbour : 
        for(int neighbour : list.get(node)){
            if(visited[neighbour] == 0){
                dfs(list , visited , st , neighbour);
            }
        }
        // when do the back track 
        // then push the node into the stack : 
        st.push(node);
    }
    public static void add_edge(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 6;
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edge(list , 2 , 3);
        add_edge(list , 3 , 1);
        add_edge(list , 4 , 0);
        add_edge(list , 4 , 1);
        add_edge(list , 5 , 0);
        add_edge(list , 5 , 2);

        ArrayList<Integer> ans = topological_sort(list, v);
        System.out.println(ans);
    }
}
/*
directed acyclic graph : 
topological sort => is a linear ordering of vertices such that if there is an edge behaviour 
u and v  , u appears before v  in that ordering . . . . . 
 */
