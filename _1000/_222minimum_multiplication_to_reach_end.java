package _1000;
import java.util.Queue;
import java.util.LinkedList;

public class _222minimum_multiplication_to_reach_end {
    public static class pair{
        int node;
        int step;
        pair(int node , int step){
            this.node = node;
            this.step = step;
        }
    }
    public static int minimum_mulitplication(int arr[] , int start , int end){
        // simple apply the bfs :
        Queue<pair> q = new LinkedList<>();
        boolean visited[] = new boolean[100000];
        
        // add the start node in the queue with step 0 : 
        q.add(new pair(start , 0));
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.peek().node;
            int step = q.peek().step;
            
            // if we reach the destination then return step : 
            if(node == end){
                return step;
            }
            // create the possibility : 
            for(int i = 0; i<arr.length; i++){
                int temp = (node * arr[i]) % 100000;
                if(visited[temp] == false){
                    q.add(new pair(temp , step + 1));
                    visited[temp] = true;
                }
            }
        }
        // if not reachable 
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
