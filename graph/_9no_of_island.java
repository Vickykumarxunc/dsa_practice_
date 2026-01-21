
import java.util.LinkedList;
import java.util.Queue;

class pair{
    int first;
    int second;
    pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
public class _9no_of_island {
    

    public static int count_island(int grid[][]){
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;

        // 8 direction array : 
        int delrow[] = {-1 , -1 , -1 , 0 , 0 , +1 , +1 , +1};
        int delcol[] = {-1 , 0 , +1 , -1 , +1 , -1 , 0 , +1};

        // traverse the grid : 
        for(int i = 0; i<row; i++){
            for(int j = 0; j<column; j++){

                // har baar jab ek naya unvisited 1 milega 
                // iska matlap ek naya iland mil gaya to us iland ke sare 1 node vo dfs se visited karke 0 mark kar do in all direction : 
                if(grid[i][j] == 1){

                    // first increase the count : 
                    count++;
                    dfs(grid , i , j ,  row , column , delrow , delcol);
                    // bfs(grid , i , j , row , col , delrow , delcol);

                }
            }
        }
        return count;
    }
    public static void dfs(int grid[][] , int i , int j ,  int row , int column , int delrow[] , int delcol[]){

        // boundary condtion : 
        if(i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == 0){
            return;
        }
        // visited the current land : 
        grid[i][j] = 0;
        for(int k = 0; k<delrow.length; k++){
            int newrow = i + delrow[k];
            int newcol  = j + delcol[k];

            dfs(grid , newrow , newcol , row , column , delrow , delcol);
        }
    }
    public static void bfs(int grid[][] , int i , int j , int row , int col , int delrow[] , int delcol[]){

        // create a queue of pair : 
        Queue<pair> q = new LinkedList<>();

        // add the current iland in the queue
        /// and mark the visited : 
        grid[i][j] = 0;
        q.add(new pair(i , j));

        // now traverse the queue : 
        while(!q.isEmpty()){

            // pop the current iland : 
            pair cell = q.remove();
            int r = cell.first;
            int c = cell.second;

            // now calculate the new row and new column : 
            for(int k = 0; k<8; k++){
                
                int newrow = r + delrow[k];
                int newcol = c + delcol[k];

                // check the valid condtion : 
                if(newrow >= 0 && newcol >= 0 && newrow < row && newcol < col && grid[newrow][newcol] == 1){

                    // add the neighbour land in the queue : 
                    q.add(new pair(newrow , newcol));
                    // mark as visited : 
                    grid[newrow][newcol] = 0;
                }
            }
        }
        /*
        🔹 BFS ka logical flow (line by line)

Queue banayi

Starting land ko:

queue me daala

visited mark kiya (0)

Jab tak queue empty nahi:

ek cell nikala

uske 8 neighbours check kiye

Jo neighbour:

boundary ke andar ho

land (1) ho
→ queue me daalo + 0 mark

Queue khali → island complete
         */
    }
    public static void main(String[] args) {
        int grid[][] = {
            {0 , 1 , 1 , 0},
            {0 , 1 , 1 , 0},
            {0 , 0 , 1 , 0},
            {0 , 0 , 0 , 0},
            {1 , 1 , 0 , 1}
        };
        int ans = count_island(grid);
        System.out.println("no of island = " + ans);
    }
}
