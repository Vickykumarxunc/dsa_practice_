import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class _23kahn_algorithm {
    public static ArrayList<Integer> topological_sort(ArrayList<ArrayList<Integer>> list , int v){

        // create a queue : 
        Queue<Integer> q = new LinkedList<>();

        // create a ans list : 
        ArrayList<Integer> ans = new ArrayList<>();

        // first calculate the indegree of the each node : 
        int indegree[] = find(list , v);

        // push all the node in the queue which have indegree is zero : 
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // traverse the queue : v + e 
        while(!q.isEmpty()){
            
            int node = q.remove();

            // add in the list of current node : 
            ans.add(node);

            // traverse the neighbour : 
            for(int neighbour : list.get(node)){

                // first remove the edge from the particular node : 
                indegree[neighbour]--;

                // agar neighbour node ki indegree 0 ho gayi to use queue me add kar do : 
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        // return the topological sort : 
        return ans;
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
    public static void add_edge(ArrayList<ArrayList<Integer>> list , int u ,int v){
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

        ArrayList<Integer> toposort = topological_sort(list, v);
        System.out.println(toposort);

    }
}
