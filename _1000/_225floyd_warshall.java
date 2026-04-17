package _1000;

public class _225floyd_warshall {
    public static void shortest_distance(int matrix[][]){
        int n = matrix.length;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                
                // if not reachable : 
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                // diagonal should always be 0 : 
                if(i == j){
                    matrix[i][j] = 0;
                }
            }
        }
        // now calculate the shortest distance : 
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    matrix[i][j] = Math.min(matrix[i][j] , matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
 