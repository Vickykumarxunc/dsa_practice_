import java.awt.desktop.QuitEvent;
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
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_u , ulp_v);
        }
        else if(size.get(ulp_v) < size.get(ulp_u)){
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_v , ulp_u);
        }
    }
}
public class _235number_of_island_online_query {
    public static ArrayList<Integer> number_of_island(int n , int m , int queries[][]){
 
        // first create a visited array : 
        boolean visited[][] = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        DisjointSet ds = new DisjointSet(n * m);

        // traverse the queries : 
        for(int i = 0; i<queries.length; i++){

            int row = queries[i][0];
            int col = queries[i][1];

            // if node is already visited :
            // continue : 
            if(visited[row][col] == true){
                list.add(count);
                continue;
            }
            // if node is not visited 
            // mark visited (create island )
            // increase the count of island : 
            visited[row][col] = true;
            count++;

            // now go the four direction
            int delrow[] = {-1 , 0 , 1 , 0};
            int delcol[] = {0 , 1 , 0 , -1};

            for(int j = 0; j<4; j++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                // boundary condition : 
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m){

                    // if neighbour node is visited 
                    // then cnnect them and create one iland : 
                    if(visited[nrow][ncol] == true){
                        int nodeNo = row * m + col;
                        int adjNodeNo = nrow * m + ncol;

                        // connectivity condition : 
                        if(ds.ulp(nodeNo) != ds.ulp(adjNodeNo)){
                            count--;
                            ds.union(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            // no of island of a particular queires 
            list.add(count);
        }
        return list;
    }
    public static void main(String args[]){

    }
}
