package _1000;
import java.util.Queue;
import java.util.LinkedList;

public class _181number_of_island {
    public static class pair{
        int row;
        int col;
        pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }

    // using the dfs : 
    public static int number_of_island(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1 , -1 , 0 , 1 , 1 , 1 , 0 , -1};
        int delcol[] = {0 , 1 , 1 , 1 , 0 , -1 , -1 , -1};
        boolean visited[][] = new boolean[n][m];
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                    mark_island(grid , visited , delrow , delcol , i , j);
                }
            }
        }
        return count;
    }
    public static void mark_island(int grid[][] , boolean visited[][] , int delrow[] , int delcol[] , int row , int col){
        visited[row][col] = true;
        for(int i = 0; i<8; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[row][ncol] == 1 && visited[nrow][ncol] == false){
                mark_island(grid , visited , delrow , delcol , nrow , ncol);
            }
        }
    }

    /// using the bfs : 
    public static int count_island(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int delrow[] = {-1 , -1 , 0 , 1 , 1 , 1 , 0 , 1};
        int delcol[] = {0 , 1 , 1 , 1 , 0 , -1 , -1 , -1};
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                    bfs(grid , visited , delrow , delcol , i , j);
                }
            }
        }
        return count;
    }
    public static void bfs(int grid[][] , boolean visited[][] , int delrow[] , int delcol[] , int i1 , int j1){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i1 , j1));
        visited[i1][j1] = true;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            for(int i = 0; i<8; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && visited[nrow][nocol] == false && grid[nrow][ncol] == 1){
                    q.add(new pair(nrow , ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
    public static void main(String args[]){

    }
}
