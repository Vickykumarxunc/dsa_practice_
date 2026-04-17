package _1000;

import java.util.PriorityQueue;

public class _220path_with_minimum_effort {
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
    /// elogv : 
    /// n * m * log(n * m)
    public static int minimum_effor(int height[][]){

        // isme hum priority queue (min heap) use karege 
        // sort based on the distance minimum distance  
        PriorityQueue<triplet> pq = new PriorityQueue<>((x , y)-> x.dist - y.dist);
        int n = height.length;
        int m = height[0].length;

        // create a 2d distance array : 
        // which is initially mark to infinity : 
        int distance[][] = new int[n][m];
        for(int i = 0;  i<n; i++){
            for(int j = 0; j<m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        // distance of source node is zero : 
        distance[0][0] = 0;
        pq.add(new triplet(0 , 0 , 0));

        // we can only traverse into four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        // now traverse the graph :
        while(!pq.isEmpty()){
            int diff= pq.peek().dist;
            int row = pq.peek().row;
            int col = pq.peek().col;

            // if reach the destination  then return the diff : 
            if(row == n - 1 && col == m - 1){
                return diff;
            }

            // now traverse the four direction : 
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){

                    // new difference : 
                    int newEffort = Math.max(Math.abs(height[row][col] - height[nrow][ncol]) , diff);

                    if(newEffort < distance[nrow][ncol]){
                        distance[nrow][ncol] = newEffort;
                        pq.add(new triplet(newEffort , nrow , ncol));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
    }
}
