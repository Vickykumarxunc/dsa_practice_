package _1000;

public class _226find_the_city_with_the_smallest_number_of_neighbour_at_a_threshold_distance {
     public static int findCity(int n , int m , int edges[][] , int distancethreshold){

        // first create a distance 2d array : 
        // initially mark to inifinity : 
        int distance[][] = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];
                distance[u][v] = w;
                distance[v][u] = w;
            }
        }
        // mark diagonal as zero : 
        for(int i = 0; i<n; i++){
            distance[i][i] = 0;
        }
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    
                    //if not reachable : 
                    if(distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j] , distance[i][j]);
                }
            }
        }
        int cityNo = -1;
        int citycount = n;
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(distance[i][j] <= distancethreshold){
                    count++;
                }
            }
            if(count <= citycount){
                cityNo = i;
                citycount = count;
            }
        }
        return cityNo;
     }
    public static void main(String[] args) {
        
    }
}
