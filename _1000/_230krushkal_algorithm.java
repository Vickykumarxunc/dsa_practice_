package _1000;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.processing.SupportedOptions;
class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for(int i = 0;i <=n; i++){
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
            parent.set(ulp_u  , ulp_v);
        }
        else if(size.get(ulp_v) < size.get(ulp_u)){
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_v , ulp_u);
        }
    }
}
class Edge implements Comparable<Edge>{
    int u;
    int v;
    int weight;
    Edge(int u , int v , int weight){
        this.u = u;
        this.weight = weight;
        this.v = v;
    }
    public int compareTo(Edge compareEdege){
        return this.weight - compareEdege.weight;
    }
}
class pair{
    int u;
    int v;
    pair(int u , int v){
        this.u = u;
        this.v = v;
    }
}
public class _230krushkal_algorithm {
    public static ArrayList<pair> spanningtree(ArrayList<ArrayList<ArrayList<Integer>>> adj ,int V){

        // create a list list which store the structure of tree : 
        ArrayList<pair> mst = new ArrayList<>();
        int cost = 0;

        // sort the edege in ascending order : 
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i<V; i++){
            for(int j = 0; i<adj.get(i).size(); j++){
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                 Edge temp = new Edge(i , adjNode , wt);
                 edges.add(temp);
            }
        }
        Collections.sort(edges , (x , y)-> x.weight - y.weight);
        DisjointSet ds = new DisjointSet(V);

        // now traverse the edge list : 
        for(int i = 0; i<edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).u;
            int v = edges.get(i).v;

            if(ds.ulp(u) != ds.ulp(v)){
                mst.add(new pair(u , v));
                cost += wt;
                ds.union(u, v);
            }
        }
        System.out.println("cost of the mst = " + cost);
        return mst;
    }
  public static void main(String[] args) {
    
  }  
}
