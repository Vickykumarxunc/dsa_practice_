package _1000;
import java.util.ArrayList;
import java.util.HashSet;

public class _188number_of_distinct_island {
    public static int number_of_distinct_island(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        HashSet<ArrayList<String>> set = new HashSet<>();
        boolean visited[][] = new boolean[n][m];

        int delrow[] = {-1 , -1 , 0 , 1 , 1 , 1 , 0 , -1};
        int delcol[] = {0 , 1 , 1 , 1 , 0 , -1 , -1 , -1};


        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){

                if(grid[i][j] == 1){

                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid , visited , list , delrow , delcol , i , j , i , j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public static void dfs(int grid[][] , boolean visited[][] , ArrayList<String> list , int delrow[] , int delcol[] , int row , int col , int row0 , int col0){
        visited[row][col] = true;
        list.add((toString(row - row0 , col - col0)));
        for(int i = 0; i<8; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1 && visited[nrow][ncol] == false){
                dfs(grid , visited , list , delrow , delcol , nrow , ncol , row0  , col0);
            }
        }
    }
    public static String toString(int row , int col){
        return Integer.toString(row) + " " + Integer.toString(col);
    }
    public static void main(String args[]){

    }
}
