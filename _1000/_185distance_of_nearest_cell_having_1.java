package _1000;
import java.util.Queue;
import java.util.LinkedList;

public class _185distance_of_nearest_cell_having_1 {
    public static class triplet{
        int row;
        int col;
        int dist;
        triplet(int row , int col , int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public static int[][] distance_nearest_1(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        int ans[][] = new int[n][m];

        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    dfs(grid , ans , delrow , delcol , i , j , 0);
                }
            }
        }
        return ans;
    }
    public static void dfs(int grid[][] , int ans[][] , int delrow[] , int delcol[] , int row , int col , int dist){
        ans[row][col] = dist;
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 0){
                dfs(grid , ans , delrow , delcol , nrow , ncol , dist + 1);
            }
        }
    }

    // using the bfs : 
    public static int[][] distance_of_nearest_cell_having_1(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        Queue<triplet> q = new LinkedList<>();

        int ans[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new triplet(i , j , 0));
                    visited[i][j] = true;
                }
            }
        }
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            ans[row][col] = dist;

            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 0 && visited[nrow][ncol] == false){
                    q.add(new triplet(nrow , ncol , dist + 1));
                    visited[nrow][ncol] = true;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
