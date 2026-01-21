import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    int time;
    Pair(int first , int second , int time){
        this.row = first;
        this.col = second;
        this.time = time;
    }
}
public class _11rotten_orange {
    public static int rotten_orange(int grid[][]){

        // hum isme multi source bfs use karege : 
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int row = grid.length;
        int col = grid[0].length;
        
        // create a visited matrix : 
        int visited[][] = new int[row][col];
        int freshOrange = 0;

        // step1 : jitne bhi rootten orange mile sab ko queue ka ander push kar do : 
        // aur sabhi fresh orange ko count karo : 
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i , j , 0));

                    // and mark as visited inside the visited array : 
                    visited[i][j] = 2;
                }
                else if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }
        // agar fresh count zero hai to return 0 kar do : 
        if(freshOrange == 0){
            return 0;
        }
        // traveser in the four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};
        int time = 0;
        // ab queue par traverse kro jab tak queue empty nahi ho jati : 
        // one by one karke rotten orange nikalo 
        // aur unke neighbour orange ko rotten karke queue me push kar do ; 
        // aur fresh count ko dreaase by 1 : 
        while(!q.isEmpty()){

            // current rotten orange ki dimension : 
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            
            // update the tiem : 
            time = Math.max(time , t);
            q.remove();

            // now travers the neighbour : 
            for(int i = 0; i<4; i++){
                int newrow = r + delrow[i];
                int newcol = c + delcol[i];

                if(newrow >= 0 && newcol >= 0 && newrow < row && newcol < col && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 1){
                    
                    // add the neighbour fresh node in the queue : 
                    // and mark as visited : 
                    q.add(new Pair(newrow , newcol , t + 1));
                    visited[newrow][newcol] = 2;

                    // decrease the freshorange : 
                    freshOrange--;
                }
            }
        }
        return freshOrange != 0 ? -1 : time;
    }
    public static void main(String[] args) {
        int grid[][] = {
            {0 , 1 , 2},
            {0 , 1 , 1},
            {2 , 1 , 1}
        };

        int ans = rotten_orange(grid);
        System.out.println("total time taken to rotten the orange = " + ans);
        
    }
}
