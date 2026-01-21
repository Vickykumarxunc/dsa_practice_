import java.util.ArrayList;
public class _20detect_cycle_in_directed_graph_using_dfs {

    public static boolean detect_cycle(ArrayList<ArrayList<Integer>> list , int v){

        // create a two array : 

        // visited array: 
        int visited[] = new int[v];

        // path visited array : 
        int pathvisited[] = new int[v];

        // now traverse the graph 
        // graph can be a disconnected graph : 
        for(int i = 0; i<v; i++){

            // if node is unvisited then apply the traversal : 
            if(visited[i] == 0){

                if(dfs(list , visited , pathvisited , i) == true){
                    return true;
                }
            }
        }
        // if cycle is not present then return false : 
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> list , int visited[] , int pathvisited[] , int node){

        // mark the current node is visited and pathvisited : 
        visited[node] = 1;
        pathvisited[node] = 1;

        // now traverse the neighbour node : 
        for(int neighbour : list.get(node)){

            // when the node is visited : 
            if(visited[neighbour] == 0){

                // agar koi se neighbour ne cycle detect kar li 
                // to hame baaki ke neighbour node ko check karne ki jarurat nahi hai : 
                if(dfs(list , visited , pathvisited , neighbour)){
                    return true;
                }
            }
            // agar node phle se hi visited hai 
            // aur vo same path par hi visited hai 
            else if(visited[neighbour] == 1){
                if(pathvisited[neighbour] == 1){
                    return true;
                }
            }
        }
        // backtrack karte vakt 
        // hum path visited ko zero kar de ge : 
        pathvisited[node] = 0;
        
        // if cycle is not present  : 
        return false;
    }
    public static void add_edge(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 11;
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edge(list , 0 , 1);
        add_edge(list , 1 , 2);
        add_edge(list , 2 , 3);
        add_edge(list , 3 , 4);
        add_edge(list , 3 , 7);
        add_edge(list , 4 , 5);
        add_edge(list , 7 , 5);
        add_edge(list , 5 , 6);
        add_edge(list , 8 , 2);
        add_edge(list , 8 , 9);
        add_edge(list , 9 , 10);
        add_edge(list , 10 , 8);

        boolean ans = detect_cycle(list, v);
        System.out.println("cycye is present or not  = " + ans);
        
    }
}
/*
directed graph me cycle kab hogi -> jab hum same path par ek node ko do baar visited kare
*/
