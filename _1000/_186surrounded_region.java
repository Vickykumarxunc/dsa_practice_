package _1000;
import java.util.Queue;
import java.util.LinkedList;
class pair{
    int row;
    int col;
    pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
public class _186surrounded_region {
    public static char[][] sorrounded_region_dfs(char grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        char ans[][] = new char[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans[i][j] = grid[i][j];
            }
        }
        boolean visited[][] = new boolean[n][m];
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        for(int j = 0; j<m; j++){
            if(grid[0][j] == 'O' && visited[0][j] == false){
                dfs(grid , visited , delrow , delcol , 0 , j);
            }
            if(grid[n - 1][j] == 'O' && visited[n - 1][j] == false){
                dfs(grid , visited , delrow , delcol ,  n - 1 , j);
            }
        }
        for(int i = 0; i<n; i++){
            if(grid[i][0] == 'O' && visited[i][0] == false){
                dfs(grid , visited , delrow , delcol ,  i , 0);
            }
            if(grid[i][m - 1] == 'O' && visited[i][m - 1] == false){
                dfs(grid , visited , delrow , delcol ,  i , m - 1);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if( grid[i][j] == 'O' && visited[i][j] == false){
                    ans[i][j] = 'X';
                }
            }
        }
        return ans;
    }
    public static void dfs(char grid[][] , boolean visited[][] , int delrow[] , int delcol[] ,  int row , int col){
        visited[row][col] = true;
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 'O' && visited[nrow][ncol] == false){
                dfs(grid , visited , delrow , delcol , nrow , ncol);
            }
        }
    }
    // using the bfs : 
    public static char[][] surrounded_bfs(char grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        char ans[][] = new char[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans[i][j] = grid[i][j];
            }
        }
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        for(int j = 0; j<m; j++){
            if(grid[0][j] == 'O' && visited[0][j] == false){
                bfs(grid , visited , delrow , delcol , 0 , j);
                visited[0][j] = true;
            }
            if(grid[n - 1][j] == 'O' && visited[n - 1][j] == false){
                bfs(grid , visited , delrow , delcol , n - 1 , j);
                visited[n - 1][j] = true;
            }
        }
        for(int i = 0; i<n; i++){
            if(grid[i][0] == 'O' && visited[i][0] == false){
                bfs(grid , visited ,delrow , delcol , i , 0);
            }
            if(grid[i][m - 1] == 'O' && visited[i][m - 1] == false){
                bfs(grid , visited , delrow , delcol , i , m - 1);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; i<m; j++){
                if(grid[i][j] == 'O' && visited[i][j] == false){
                    ans[i][j] = 'X';
                }
            }
        }
        return ans;
    }
    public static void bfs(char grid[][] , boolean visited[][] , int delrow[] , int delcol[] , int row , int col){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(row , col));

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 'O' && visited[nrow][ncol] == false){
                    q.add(new pair(nrow , ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
