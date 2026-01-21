import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class _27eventually_safe_state_using_bfs {

    public static ArrayList<Integer> eventualSafeNode(ArrayList<ArrayList<Integer>> list  , int v){

        // first reverse the graph : 
        // and calculate the indegree of each node : 
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                adjRev.get(neighbour).add(i);
                indegree[i]++;
            }
        }
        // push the all node in the queue which have zero indegree : 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // create a ans list which contain the safe node : 
        ArrayList<Integer> ans = new ArrayList<>();

        // now traverse the queue : (v + e)
        while(!q.isEmpty()){

            int node = q.remove();
            ans.add(node);

            // traverse the neighbour : 
            for(int neighbour : adjRev.get(node)){
                
                // remove the edge : 
                indegree[neighbour]--;

                // agar neighbour node ki indegree 0 ho jaye to use queue me push kar do : 
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        // sort the ans 
        Collections.sort(ans);
        return ans;
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
        add_edge(list , 2 , 4);
        add_edge(list , 3 , 4);
        add_edge(list , 3 , 5);
        add_edge(list , 4 , 6);
        add_edge(list , 5 , 6);
        add_edge(list , 6 , 7);
        add_edge(list , 8 , 9);
        add_edge(list , 9 , 10);
        add_edge(list , 10 , 8);
        add_edge(list , 11 , 9);

        ArrayList<Integer> ans = eventualSafeNode(list, v);
        System.out.println(ans);
    }
}
