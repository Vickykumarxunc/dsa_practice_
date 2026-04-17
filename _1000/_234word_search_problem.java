package _1000;

public class _234word_search_problem {
    public static boolean wordsearch(char grid[][] , String word){

        int n = grid.length;
        int m = grid[0].length;
        
        // create a visited array 
        boolean visited[][] = new boolean[n][m];

        // we traverse only in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        // traverse the grid : 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){

                // jaishe hi mujhe word ka first character milega 
                // to mai dfs traverse karuga remaing word ko find karne ke liye : 
                if(grid[i][j] == word.charAt(0)){
                    
                    // if word find : 
                    if(dfs(grid , visited , delrow , delcol , word , i , j , 0) == true){
                        return true;
                    }
                }
            }
        }
        // if word not find : 
        return false;
    }
    // implementtation of the dfs : 
    public static boolean dfs(char grid[][] , boolean visited[][] , int delrow[] , int delcol[] , String word , int row , int col , int index){

        // agar main pura word traverse kar liya
        // matlab word grid me present hai : 
        if(index == word.length() - 1){
            return true;
        }
        // mark the visited current character : 
        visited[row][col] = true;

        // traverse the four direction  ;
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // valid condition : 
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == word.charAt(index + 1) && visited[nrow][ncol] == false){
                if(dfs(grid , visited , delrow , delcol , word , nrow , ncol , index + 1) == true){
                    return true;
                }
            }
        }
        // back track them : if word is not found : 
        visited[row][col] = false;
        return false;
    }
    public static void main(String[] args) {
        
    }
}
