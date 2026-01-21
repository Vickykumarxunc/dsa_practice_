
import java.util.ArrayList;
public class _2adjacency_list {
    public static void add_edges(ArrayList<ArrayList<Integer>> list , int u , int v){
        list.get(u).add(v); // u->v
        list.get(v).add(u); // v->u
    }
    public static void print(ArrayList<ArrayList<Integer>> list , int V){
        for(int i = 0; i<V; i++){
            System.out.print(i + " -> " );
            
            // now print the neighbour node of the i : 
            for(int neighbour : list.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 5;
        for(int i = 0; i<=v; i++){
            list.add(new ArrayList<>());
        }
        
        // add edges : 
        add_edges(list , 1 , 2);
        add_edges(list , 1 , 3);
        add_edges(list , 2 , 4);
        add_edges(list , 2 , 5);
        add_edges(list , 3 , 4);
        add_edges(list , 4 , 5);

        // print the graph : 
        print(list, v + 1);

    }
}
/*
time complexity = O(v + e)
space complexity = O(v + e)
 */
