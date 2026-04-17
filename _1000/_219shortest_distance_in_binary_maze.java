package _1000;
import java.util.LinkedList;
import java.util.Queue;

public class _219shortest_distance_in_binary_maze {
     public static class triplet{
        int dist;
        int row;
        int col;
        triplet(int dist , int row , int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
     }
     public static int shortestpath(int grid[][] , int source[] , int destination[]){

        // isme hum dijkastralagorithm use karege with simple queue : 
        // 4 direction me traverse karege  : 

        // if source and destination are same : 
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }
        // create a queue : 
        Queue<triplet> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        // create a 2d distance array : 
        int  distance[][] = new int[n][m];

        // initially distance array mark as infinity : 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        //we traverse in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        // mark the source as distance 0 and put into the queue: 
        distance[source[0]][source[1]] = 0;
        q.add(new triplet(0 , source[0] , source[1]));

        // traverse the queue : 
        while(!q.isEmpty()){
            int dist = q.peek().dist;
            int row = q.peek().row;
            int col = q.peek().col;

            // go in the four direction : 
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && dist + 1 < distance[nrow][ncol]){
                    distance[nrow][ncol] = 1 + dist;

                    // if we reach at destination : 
                    if(nrow == destination[0] && ncol == destination[1]){
                        return dist + 1;
                    }
                    q.add(new triplet(dist + 1 , nrow , ncol));
                }
            }
        }
        // if we not reached : 
        return -1;
     }
    public static void main(String[] args) {
        
    }
}
