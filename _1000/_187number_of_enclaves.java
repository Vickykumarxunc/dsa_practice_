package _1000;
import java.util.Queue;
import java.util.LinkedList;
public class _187number_of_enclaves {
    public static class pair{
        int row;
        int col;
        pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    // number of enclaves using dfs : 
    public static int count_enclaves_using_dfs(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        for(int j = 0; j<m; j++){
            if(grid[0][j] == 1 && visited[0][j] == false){
                dfs(grid , visited , delrow , delcol , 0 , j);
            }
            if(grid[n - 1][j] == 1 && visited[n - 1][j] == false){
                dfs(grid , visited , delrow , delcol , n - 1 , j);
            }
        }
        for(int i = 0; i<n; i++){
            if(grid[i][0] == 1 && visited[i][0] == false){
                dfs(grid , visited , delrow , delcol , i , 0);
            }
            if(grid[i][ m - 1] == 1 && visited[i][m - 1] == false){
                dfs(grid , visited , delrow , delcol , i , m -1 );
            }
        }
        int count = 0;
        for(int i = 0 ;i<n; i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int grid[][] ,  boolean visited[][] , int delrow[] , int delcol[] , int row , int col){
        visited[row][col] = true;
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1 && visited[nrow][ncol] == false){
                dfs(grid , visited , delrow , delcol , nrow , ncol);
            }
        }
    }
    // number of enclaves using the bfs : 
    public static int count_enclaves_using_bfs(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        for(int j = 0; j<m; j++){
            if(grid[0][j] == 1 && visited[0][j] == false){
                bfs(grid , visited , delrow , delcol , 0 , j);
                visited[0][j] = true;
            } 
            if(grid[n - 1][j] == 1 && visited[n - 1][j] == false){
                bfs(grid , visited , delrow , delcol , n - 1 , j);
                visited[n - 1][j] = true;
            }
        }
        for(int i = 0; i<n; i++){
            if(grid[i][0] == 1 && visited[i][0] == false){
                bfs(grid , visited , delrow , delcol , i , 0);
                visited[i][0] = true;
            }
            if(grid[i][m - 1] == 1 && visited[i][m - 1] == false){
                bfs(grid , visited , delrow , delcol , i , m - 1);
                visited[i][m - 1] = true;
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; i<m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(int grid[][] , boolean visited[][] , int delrow[] , int delcol[] , int row , int col){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(row , col));
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            for(int i = 0; i<4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1 && visited[nrow][ncol] == false){
                    q.add(new pair(nrow , ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
