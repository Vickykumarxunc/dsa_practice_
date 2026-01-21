import java.util.ArrayList;
import java.util.HashSet;
public class _17no_of_distinct_island {
    public static int count_distinct_island(int grid[][]){
        int row = grid.length;
        int col = grid[0].length;
        
        // create a visited array : 
        int visited[][] = new int[row][col];

        // here we traverse only in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , -1 , 0 , 1};

        // to store the structure we use the set data structure : 
        HashSet<ArrayList<String>> set = new HashSet<>();

        // jaise hi mujhe unvisited 1 milega to vo ek island hoga : 
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){

                    // create a list for each iland to store structure of a particular iland  : 
                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid , visited , list , i , j , delrow , delcol , i , j);
                    
                    // set contain only distinct iland : 
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public static void dfs(int grid[][] , int visited[][] , ArrayList<String> list , int row , int col , int delrow[] , int delcol[] , int row0 , int col0){

        // condition : 
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == 0 || visited[row][col] == 1){
            return;
        }
        // mark as visited of current node : 
        visited[row][col] = 1;

        // add into the list by substracting the base : 
        list.add(toString(row - row0 , col - col0));

        // now traverse the neighbour : 
        for(int i = 0; i<4; i++){
            int newrow = row + delrow[i];
            int newcol = col + delcol[i];
            dfs(grid , visited , list , newrow , newcol , delrow , delcol , row0 , col0);
        }
    }
    public static String toString(int r , int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
   public static void main(String[] args) {
    int grid[][] = {
        {1 , 1 , 0 , 1 , 1},
        {1 , 0 , 0 , 0 , 0},
        {0 , 0 , 0 , 1 , 1},
        {1 , 1 , 0 , 1 , 0}
    };

    int ans = count_distinct_island(grid);
    System.out.println("no of distinct island = " + ans);
   } 
}
