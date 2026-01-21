
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}

/*
? simple logic -> boundary par traverse karo 1 mile to dfs or bfs apply karo aur unke neighbour ko mark kar do 
? baad me jitne unvisited 1 bach gaye unhe count kar lo : 
 */
public class _16number_of_enclaves {
    public static int no_of_enclaves(int grid[][]){
        int row = grid.length;
        int col = grid[0].length;

        // create a visited array: 
        int visited[][] = new int[row][col];

        // move only in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        // traveres the boundary : 

        // top : 
        for(int i = 0; i<col; i++){
            if(grid[0][i] == 1 && visited[0][i] == 0){
                dfs(grid , visited , 0 , i , delrow , delcol);
            }
        }
        // right : 
        for(int i = 0; i<row; i++){
            if(grid[i][col - 1] == 1 && visited[i][col - 1] == 0){
                dfs(grid , visited , i , col - 1 , delrow , delcol);
            }
        }
        // bottom : 
        for(int i = 0; i<col; i++){
            if(grid[row - 1][i] == 1 && visited[row - 1][i] == 0){
                dfs(grid , visited , row - 1 , i , delrow , delcol);
            }
        }
        // left : 
        for(int i = 0; i<row; i++){
            if(grid[i][0] == 1 && visited[i][0] == 0){
                dfs(grid , visited , i , 0 , delrow , delcol);
            }
        }

        // now count the no of enclaves : 
        int count = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int grid[][] , int visited[][] , int row , int col , int delrow[] , int delcol[]){

        // condition : 
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == 0 || visited[row][col] == 1){
            return;
        }
        // marks it visited : 
        visited[row][col] = 1;

        // now traverse the neighbour in the four direction : 
        for(int i = 0; i<4; i++){
            int newrow = row + delrow[i];
            int newcol = col + delcol[i];

            dfs(grid , visited , newrow , newcol , delrow , delcol);
        }
    }

    // now using the bfs : 
    public static int count(int grid[][]){
        int row = grid.length;
        int col = grid[0].length;

        // create a visited array  : 
        int visited[][] = new int[row][col];

        // traverse only in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        Queue<Pair> q = new LinkedList<>();

        // push the all the bourndary one in the queue : 
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){

                // boundary coundition : 
                if(i == 0 || j ==  0 || i == row - 1 || j == col - 1){

                    if(grid[i][j] == 1){
                        q.add(new Pair(i , j));
                        
                        // and mark it visited : 
                        visited[i][j] = 1;
                    }
                }
            }
        }

        // now traverse the neighbour in four direction : 
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;

            for(int i = 0; i<4; i++){
                int newrow = r + delrow[i];
                int newcol = c + delcol[i];

                if(newrow < row && newcol < col && newrow >= 0 && newcol >= 0 && grid[newrow][newcol] == 1 && visited[newrow][newcol] != 1){
                    q.add(new Pair(newrow , newcol));
                    visited[newrow][newcol] = 1;
                }
            }
        }
        // now count the no of enclaves : 
        int count = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int grid[][] = {
            {0 , 0 , 0 , 1},
            {0 , 1 , 1 , 0},
            {0 , 1 , 1 , 0},
            {0 , 0 , 0 , 1},
            {0 , 1 , 1 , 0}
        };

        int ans = no_of_enclaves(grid);
        System.out.println("no of enclaves = " + ans);

    }
}
/*
move only in four direction : 
0 -> sea
1 -> land

hame ve  1 count karne hai jo boundary se connected nahi hai: 

 */

/*
 
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
