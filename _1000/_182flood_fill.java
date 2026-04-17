package _1000;

import java.util.LinkedList;

public class _182flood_fill {
    public static class pair{
        int row;
        int col;
        pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    // using the dfs : 
    public static int[][] flood_fill(int grid[][] , int sr , int sc , int new_color){
        int n = grid.length;
        int m = grid[0].length;
        int initial_color = grid[sr][sc];
    
        int ans[][] = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans[i][j] = grid[i][j];
            }
        }
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};
        dfs(grid , ans , delrow , delcol , initial_color , new_color , sr , sc);

        return ans;
    }
    public static void dfs(int grid[][] , int ans[][] , int delrow[] , int delcol[] , int intital_color , int new_color , int sr, int sc){
        ans[sr][sc] = new_color;
        for(int i = 0; i<4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == intital_color && ans[nrow][ncol] != new_color){
                dfs(grid , ans , delrow , delcol , intital_color , new_color , nrow , ncol);
            }
        }
    }
    // using the bfs : 
    public static int[][] flood_fill_algorithm(int grid[][] , int sr , int sc , int new_color){
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        int ans[][] = new int[n][m];
        int initial_color = grid[sr][sc];
    
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans[i][j] = grid[i][j];
            }
        }
        bfs(grid , ans , delrow , delcol , sr , sc , initial_color , new_color);
        return ans;
    }
    public static void bfs(int grid[][] , int ans[][] , int delrow[] , int delcol[] , int row , int col , int initial_color , int new_color){
        java.util.Queue<pair> q = new LinkedList<>();
        q.add(new pair(row , col));
         

        while(!q.isEmpty()){
            int r1 = q.peek().row;
            int c1 = q.peek().col;
            ans[r1][c1] = new_color;
            q.remove();
            for(int i = 0; i<4; i++){
                int nrow = r1 + delrow[i];
                int ncol = c1 + delcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < grid[0].length && ncol < grid[0].length && grid[nrow][ncol] == initial_color && ans[nrow][ncol] != new_color){
                    q.add(new pair(nrow , ncol));
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
