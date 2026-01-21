import java.util.ArrayList;
public class _19bipartite_graph_using_dfs {
    public static boolean bipartite_graph(ArrayList<ArrayList<Integer>> list , int v){

        // create a visited array : 
        int color[] = new int[v];
        for(int i = 0; i<v; i++){
            color[i] = -1;
        }

        // graph can be disconnected : 
        for(int i = 0; i<v; i++){

            if(color[i] == -1){
            if(check_dfs(list , color , i , 0) == false){
                return false;
            }
        }
        }
        return true;
    }
    public static boolean check_dfs(ArrayList<ArrayList<Integer>> list , int color[] , int node ,  int col){
        
        // color the current node : 
        color[node] = col;

        // traverse the adjacency neighbour : 
        for(int neighbour : list.get(node)){
            if(color[neighbour] == -1){
                if(check_dfs(list , color , neighbour , 1 - col) == false){
                    return false;
                }
            }
            else if(color[neighbour] == col){
                return false;
            }
        }
        return true;
    }
    public static void add_edge(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 8;
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edge(list , 0 , 1);
        add_edge(list , 1 , 2);
        add_edge(list , 2 , 3);
        add_edge(list , 3 , 4);
        add_edge(list , 1 , 5);
        add_edge(list , 3 , 6);
        add_edge(list , 6 , 7);
        add_edge(list , 5 , 4);

        boolean ans = bipartite_graph(list, v);
        System.out.println("graph is bipartite or not = " + ans);

        
    }
}
