
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class _25prerequisite_task {
    public static boolean isPossible(int prerequisist[][] , int v){

        // first create a adjacency list : 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }
        int n = prerequisist.length;
        for(int i = 0; i<n; i++){
            list.get(prerequisist[i][0]).add(prerequisist[i][1]);
        }
        // now apply the topological sort : 
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        // create a queue : 
        Queue<Integer> q = new LinkedList<>();

        // add all the node which have indegree 0 : 
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // take a count variable which maintain the toposort size : 
        int count = 0;
        while(!q.isEmpty()){

            int node = q.remove();
            count++;

            for(int neighbour : list.get(node)){
                
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        // agar cycle prsent hai to task hum perform nahi kar sakte : 
        return count == v;
    }
    public static void main(String[] args) {
        int v = 4;
        int prerequisist[][] = {
            {1 , 0},
            {2 , 1},
            {3 , 2}
        };

        boolean ans = isPossible(prerequisist, v);
        System.out.println(ans);
    }
}
