package _1000;
import java.util.ArrayList;

class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    int ulp(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = ulp(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    void union(int u , int v){
        int ulp_u = ulp(u);
        int ulp_v = ulp(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        }
        else if(size.get(ulp_v) < size.get(ulp_u)){
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
public class _232number_of_operations_to_make_network_connected {
    public static int minimum_operation(int  n , int edges[][]){
        
        DisjointSet ds = new DisjointSet(n);

        // first find the extra edges :
        int extra_edge = 0;
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(ds.ulp(u) == ds.ulp(v)){
                extra_edge++;
            }
            else{
                ds.union(u, v);
            }
        }
        // now calculate the component :
        int component = 0;
        for(int i = 0; i<n; i++){
            if(ds.ulp(i) == i){
                component++;
            }
        }
        int ans = component - 1;
        if(extra_edge >= ans){
            return ans;
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
