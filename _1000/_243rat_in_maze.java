package _1000;

import java.util.ArrayList;

public class _243rat_in_maze {
    public static ArrayList<String> rat_in_maze(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 0){
            return new ArrayList<>();
        }
        boolean visited[][] = new boolean[n][m];
        int delrow[] = {1 , 0 , 0 , -1};
        int delcol[] = {0 , -1 , 1 , 0};

        ArrayList<String> ans = new ArrayList<>();
        dfs(grid , visited , delrow , delcol , ans , 0 , 0 , "");
        return ans;
    }
    public static void dfs(int grid[][] , boolean visited[][] , int delrow[] , int delcol[] , ArrayList<String> ans , int row , int col , String path){
        visited[row][col] = true;
        if(row == grid.length - 1 && col == grid[0].length - 1){
            ans.add(path);
            return;
        }
        String dir = "DLRU";
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1 && visited[nrow][ncol] == false){
                dfs(grid , visited , delrow , delcol , ans , nrow , ncol , path + dir.charAt(i));
            }
        }
        visited[row][col] = false;
    }
    public static void main(String[] args) {
        
    }
}
