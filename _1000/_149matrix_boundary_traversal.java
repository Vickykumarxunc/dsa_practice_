package _1000;

import java.util.ArrayList;

public class _149matrix_boundary_traversal {
    public static ArrayList<Integer> boundary_traversal(int matrix[][]){
        ArrayList<Integer> list = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;

        // top : 
        for(int j = 0; j<c; j++){
            list.add(matrix[0][j]);
        }
        // right :
        for(int i = 1; i<r; i++){
            list.add(matrix[i][c - 1]);
        }
        // bottom : 
        for(int j = c - 2; j>= 0; j--){
            list.add(matrix[r - 1][j]);
        }
        // left : 
        for(int i = r - 2; i >= 1; i--){
            list.add(matrix[i][0]);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
