public class _15replace_O_with_X {
    public static void dfs(char ch[][] , int visited[][] , int row , int col , int delrow[] , int delcol[]){

        // base condition : 
        if(row < 0 || col < 0 || row >= ch.length || col >= ch[0].length || visited[row][col] == 1 || ch[row][col] == 'x'){
            return;
        }
        visited[row][col] = 1;

        // traverse the neighbour of node in four direction : 
        for(int i = 0; i<4; i++){
            int newrow = row + delrow[i];
            int newcol = col + delcol[i];

            // apply the dfs call : 
            dfs(ch , visited , newrow , newcol , delrow , delcol);
        }
    }
    public static char[][] replace(char ch[][]){
        int row = ch.length;
        int col = ch[0].length;

        // create a visited matrix : 
        int visited[][] = new int[row][col];

        // create a ans matrix : 
        char ans[][] = new char[row][col];

        // traverse only four direction : 
        int delrow[] = {-1 , 0 , +1 , 0};
        int delcol[] = {0 , +1 , 0 , -1};

        // only traverse the boundary : 
        //? start from the boundary O's and marks as visited then that not be converted . 
        //? and remaining O's converted to x : 

        // top boundary : 
        for(int i = 0; i<col; i++){
            if(ch[0][i] == '0'){
                // apply the dfs and mark as visited : 
                dfs(ch , visited , 0 , i , delrow , delcol);
            }
        }
        // right boundary : 
        for(int i = 0; i < row; i++){
            if(ch[i][col - 1] == '0'){
                dfs(ch , visited , i , col - 1 , delrow , delcol);
            }
        }
        // bottom boundary : 
        for(int i = 0; i < col; i++){
            if(ch[row - 1][i] == '0'){
                dfs(ch , visited , row - 1 , i , delrow , delcol);
            }
        }
        // left boudary : 
        for(int i = 0; i< row; i++){
            if(ch[i][0] == '0'){
                dfs(ch , visited ,  i , 0 , delrow , delcol);
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(ch[i][j] == '0' && visited[i][j] == 0){
                    ans[i][j] = 'x';
                }
                else{
                    ans[i][j] = ch[i][j];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        char ch[][] = {
            {'x' , 'x' , 'x' , 'x' , 'x'},
            {'x' , '0' , '0' , 'x' , '0'},
            {'x' , 'x' , '0' , 'x' , '0'},
            {'x' , '0' , 'x' , '0' , 'x'},
            {'0' , '0' , 'x' , 'x' , 'x'}
        };

        char ans[][] = replace(ch);

        for(int i = 0; i<ch.length; i++){
            for(int j = 0; j<ch[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*
time complexity = O(n*m)
space complexity = O(n*m)
 */
