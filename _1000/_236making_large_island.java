package _1000;
import java.util.ArrayList;
import java.util.HashSet;

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
        if(ulp_v == ulp_u){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
            parent.set(ulp_u , ulp_v);
        }
        if(size.get(ulp_v) < size.get(ulp_u)){
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
public class _236making_large_island {
    public static int MaxConnection(int grid[][]){
        int n = grid.length;
        
        // use the disjoint set : 
        DisjointSet ds = new DisjointSet(n * n);

        // step 1 : create a connected componenet : 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int delrow[] = {-1 , 0 , 1 , 0};
                int delcol[] = {0 , -1 , 0 , 1};
                
                // traverse into the four direction : 
                for(int k = 0; k<4; k++){
                    int nrow = i + delrow[k];
                    int ncol = j + delcol[k];

                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && grid[nrow][ncol] == 1){
                        int nodeNo = i * n + j; //(row * n + col)
                        int adjNodeNo = nrow * n + ncol;
                        ds.union(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        // step 2 convert zero to one and try to create a largest component : 
        int max = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    continue;
                }
                // traverse in four direction : 
                int delrow[] = {-1 , 0 , 1 , 0};
                int delcol[] = {0 , -1 , 0 , 1};

                // create a hashset to store the ultimate parent of the neighbour componenet 
                // to prevent the duplicate component : 
                HashSet<Integer> component = new HashSet<>();
                for(int ind = 0; ind < 4; ind++){
                     
                    int nrow = row + delrow[ind];
                    int ncol = col + delcol[ind];

                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < n){
                        if(grid[nrow][ncol] == 1){

                            // store the uptimate parent of the component into the set: 
                            component.add(ds.ulp(nrow * n + ncol));
                        }
                    }
                }
                int total_size = 0;
                for(int parent : component){
                    total_size += ds.size.get(parent);
                }
                max = Math.max(total_size + 1 , max);
            }
        }
        // if all are one : 
        for(int cellNo = 0; cellNo < n * n; cellNo++){
            max = Math.max(max , ds.size.get(ds.ulp(cellNo)));
        }
        return max;
    }
    public static void main(String[] args) {
        
    }
}
