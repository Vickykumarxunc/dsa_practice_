import java.util.ArrayList;
import java.util.Collections;
public class _21eventual_safe_state_using_dfs {
    public static ArrayList<Integer> find_safe_state(ArrayList<ArrayList<Integer>> list , int v){

        // apply the concept of the detect the cycle in the directed graph : 
        int visited[] = new int[v];
        int pathvisited[] = new int[v];
        
        // ek array banao ye mark karega safe node ko backtrack karte vakt : 
        int check[] = new int[v];

        for(int i = 0; i<v; i++){
            if(visited[i] == 0){
                dfs(list , visited , pathvisited , check , i);
            }
        }
        // create a ans list : 
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<v; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        // sort the list : 
        Collections.sort(ans);
        return ans;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> list , int visited[] , int pathvisited[] , int check[] , int node){

        // mark as visited : and path visited : 
        visited[node] = 1;
        pathvisited[node] = 1;
        check[node] = 0;
        
        // check the adjacency node: 
        for(int neighbour : list.get(node)){
            
            // agar neighbour visited nahi hai :
            // agar kisi neighbour ne hi cycle detect kar li to baaki ne neighbour ko check karne ki jarurat nahi hai :  
            if(visited[neighbour] == 0){
                if(dfs(list , visited , pathvisited , check , neighbour) == true){
                    return true;
                }
            }
            // agar neighbour visited hai aur vo path visited bhi hai to cyccyle present hai : 
            else if(visited[neighbour] == 1){
                if(pathvisited[neighbour] == 1){
                    return true;
                }
            }
        }
        // agar cycyle present nahi hai 
        // or further recursive call nahi hai 
        // to back track karte vakt 
        check[node] = 1;
        pathvisited[node] = 0;
        return false;
    }
    public static void add_edge(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 12; 
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        add_edge(list , 0 , 1);
        add_edge(list , 1 , 2);
        add_edge(list , 2 , 3);
        add_edge(list , 3 , 4);
        add_edge(list , 3 , 5);
        add_edge(list , 4 , 6);
        add_edge(list , 5 , 6);
        add_edge(list , 6 , 7);
        add_edge(list , 8 , 1);
        add_edge(list , 8 , 9);
        add_edge(list , 9 , 10);
        add_edge(list , 10 , 8);
        add_edge(list , 11 , 9);

        ArrayList<Integer> anss = find_safe_state(list, v);
        System.out.println(anss);
    }
}
/*
jo node mere cycle ke part hoge vo kabhi bhi safe node nahi hoge : 
aur jo node lead to the cycle hoge vo bhi safe node nahi hoge : 
 */
