package _1000;

public class _143transpose_matrix {
    public static int[][] transpose(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for(int j = i; j<m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        
    }
}
