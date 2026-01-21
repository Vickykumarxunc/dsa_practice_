
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int node;
    int parent;
    Pair(int node , int parent){
        this.node = node;
        this.parent = parent;
    }
}

public class _12detect_cycle_using_bfs {

    // detect cycle using the bfs : 
    public static boolean bfs(ArrayList<ArrayList<Integer>> list , int start , boolean visited[]){

        // create a queue : 
        Queue<Pair> q = new LinkedList<>();
 
        // concept of cycle is : 
        // agar node visited hai aur vo parent nahi hai to cycle hai : 

        // push the start node in the queue with parent -1 : 
        q.add(new Pair(start , -1));
        visited[start] = true;

        // traverse the queue : 
        while(!q.isEmpty()){

            // remove the node : 
            Pair curr = q.remove();
            int node = curr.node;
            int parent = curr.parent;

            // check the neighbour : 
            for(int neighbour : list.get(node)){

                if(visited[neighbour] == false){

                    // mark as visited and add into the queue with parent node : 
                    visited[neighbour] = true;
                    q.add(new Pair(neighbour , node));
                }
                // agar vo phle se hi visited hai ar parent nahi hai to cycle presnt hai : 
                else if(visited[neighbour] == true){
                    if(neighbour != parent){
                        return true;
                    }
                }
            }
        }
        // if cycle is not present 
        return false;
    }
    public static boolean detect(ArrayList<ArrayList<Integer>> list , int v){

        // create a visited array : 
        boolean visited[] = new boolean[v];

        // mera graph disconnected graph bhi ho sakta hia :
        for(int i = 0; i<v; i++){

            // agar node unvisited hai : 
            // to bfs apply karo : 
            if(visited[i] == false){

                if(bfs(list , i , visited)){
                    return true;
                }
            }
        }
        return false;
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
        add_edge(list , 1 , 3);
        add_edge(list , 2 , 3);
        add_edge(list , 3 , 6);
        add_edge(list , 3 , 4);
        add_edge(list , 5 , 7);
        add_edge(list , 6 , 7);

        boolean ans = detect(list, v);
        System.out.println("cycle is present or not  = " + ans);
        


    }
}
