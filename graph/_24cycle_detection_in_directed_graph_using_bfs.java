import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class _24cycle_detection_in_directed_graph_using_bfs {
    public static boolean detect_cycle(ArrayList<ArrayList<Integer>> list , int v){

        // create a queue : 
        Queue<Integer> q = new LinkedList<>();

        // calculate the indegree of each node : 
        int indegree[] = find(list , v);

        // queue me ve saare node push kar do  jiski indegree 0 hai : 
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        // ab traverse karo jab tak queue empty na ho jaye : 
        while(!q.isEmpty()){

            // remove the current node : 
            int node = q.remove();
            count++;

            // traverse the neighbour : 
            for(int neighbour : list.get(node)){

                // break the edge : 
                indegree[neighbour]--;

                // agar neighbour node ki indegree zero ho gay to use queue me push kar do : 
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        // ab check karo cycle present hai ya nahi : 
        // agar sabhi node ki indegree zero ho gayi to cycle present nahi hai
        // agar sabhi node ki indegree zero nahi hui to cycle present hai : 
        return count != v;
    }
    public static int[] find(ArrayList<ArrayList<Integer>> list , int v){
        
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        return indegree;
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
        add_edge(list , 1 , 2);
        add_edge(list , 2 , 3);
        add_edge(list , 3 , 4);
        add_edge(list , 4 , 2);
        add_edge(list , 3 , 5);

        boolean ans = detect_cycle(list, v);
        System.out.println("cycle is present or not " + ans);
        
    }
}
