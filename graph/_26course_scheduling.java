import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class _26course_scheduling {
    public static int[] findOrder(int n  , int m , ArrayList<ArrayList<Integer>> prerequistes){

        // create a adjancency list : 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            list.get(prerequistes.get(i).get(1)).add(prerequistes.get(i).get(0));
        }
        // apply the topological sort : 

        // find the indegree of each Node : 
        int indegree[] = new int[n];
        for(int i = 0; i<n; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        // create a queue 
        Queue<Integer> q = new LinkedList<>();

        // add the all node in the queue which have zero indegree : 
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // now createa topo array which store the topological order : 
        int topo[] = new int[n];
        int i = 0;

        while(!q.isEmpty()){

            int node = q.remove();
            topo[i++] = node;

            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if(i == n){
            return topo;
        }
        int arr[] = {};
        return arr;
    }
    public static void main(String[] args) {
        int n = 2;
        int m = 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(0);
        list.add(temp);

        int ans[] = findOrder(n , m , list);
        for(int i  = 0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
