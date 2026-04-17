package _1000;
import java.util.ArrayList;
class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for(int i = 0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int ulp(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = ulp(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    public void union(int u , int v){
        int ulp_u = ulp(u);
        int ulp_v = ulp(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_u , ulp_v);
        }
        else if(size.get(ulp_v) < size.get(ulp_u)){
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
            parent.set(ulp_v , ulp_u);
        }
    }
}
 
public class _231number_of_proviences_using_dsu {
    public static int number_of_proviences(ArrayList<ArrayList<Integer>> adj , int v){

        DisjointSet ds = new DisjointSet(v);

        // first find the union : 
        for(int i = 0; i<v; i++){
             for(int j = 0; j<v; j++){
                if(adj.get(i).get(j) == 1){
                    ds.union(i, j);
                }
             }
        }
        int count = 0;
        for(int i = 0; i<v; i++){
            if(ds.ulp(i) == i){
                count++;
            }
        }
        return count;
    }
   public static void main(String[] args) {
    
   } 
}
