
import java.util.ArrayList;
public class _5no_of_connected_component {
    public static int count_proviences(ArrayList<ArrayList<Integer>> list , int v){
         
        // create a count varaible which count the no of proviences : 
        int count = 0;

        // create a visited array 
        // ye ensure karege ki kon sa array visited hua hi : 
        boolean visited[] = new boolean[v];

        // ab hum har ek componenet par traverse karege 
        // jitni baar for loop chalege 
        // mere graph me utne hi connected component hoge : 
        for(int i = 0; i<v; i++){

            // agar i node unvisited hai to vo ek componenet hai dfs apply karo : 
            if(visited[i] == false){

                // increase the count : 
                count++;
                // apply the dfs call to mark the all node of one component is visited : 
                dfs(list , visited , i); // 1dfs = 1 proviences : 
            }
        }
        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> list , boolean visited[] , int node){

        visited[node] = true;
        for(int neighbour : list.get(node)){
            if(visited[neighbour] == false){
                dfs(list , visited , neighbour);
            }
        }
    }
    public static void add_edges(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 6;
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edges(list , 0 , 1);
        add_edges(list , 2 , 3);
        add_edges(list , 4 , 5);

        int ans = count_proviences(list, v);
        System.out.println("number of connected component = " + ans);

    }
}
/*
time complexity : O(N) + (v + 2E)
space complexity : O(N)

 */