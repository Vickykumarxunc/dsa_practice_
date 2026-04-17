package _1000;

import java.util.LinkedList;
import java.util.Queue;

public class _183rotten_orange {
    public static class triplet{
        int row;
        int col;
        int time;
        triplet(int row , int col , int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public static int rotten_orange(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        int fresh_orange = 0;

        Queue<triplet> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new triplet(i , j , 0));
                    visited[i][j] = true;
                }
                else if(grid[i][j] == 1){
                    fresh_orange++;
                }
            }
        }
        if(fresh_orange == 0){
            return 0;
        }
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        int time = 0;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time , t);

            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && ncol >= 0 && ncol < grid[0].length && nrow < grid.length && grid[nrow][ncol] == 1 && visited[nrow][ncol] == false){
                    q.add(new triplet(nrow , ncol , t + 1));
                    visited[nrow][ncol] = true;
                }
            }
        }
        return fresh_orange != 0 ? -1 : time;
    }
    public static void main(String[] args) {
        
    }
}
