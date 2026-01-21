
import java.util.ArrayList;

public class _4dfs_traversal {
    public static void dfs_traversal(ArrayList<ArrayList<Integer>> list , boolean  visited[] , ArrayList<Integer> ans , int node){

        // add the current node into the ans list : 
        ans.add(node);

        // mark the current node a visited in visited array : 
        visited[node] = true;

        // now traverse the neighbour node  : 
        for(int neighbour : list.get(node)){

            // agar current node ka neighbour visit nahi hua a 
            // to use visited karo apply the dfs :
            if(visited[neighbour] == false) 
            dfs_traversal(list , visited , ans , neighbour);
        }
    }
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> list , int v){

        // create a list which store the dfs traversal : 
        ArrayList<Integer> ans = new ArrayList<>();

        // create a visited array : 
        // ye ensure karege ki kon kon sa node visited ho gaya hai :
        boolean visited[] = new boolean[v];

        // now apply the recursive function : 
        dfs_traversal(list , visited , ans , 0);
        return ans;
    }
    public static void add_edges(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v); // u->v
        list.get(v).add(u); // v->u
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 5;

        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edges(list , 0 , 1);
        add_edges(list , 0 , 2);
        add_edges(list , 1 , 3);
        add_edges(list , 2 , 4);

        ArrayList<Integer> dfs = dfs(list , v);
        System.out.println(dfs);

    }
}
/*
time complexity : O(V + E);
space complexity : )(V + E);
 */