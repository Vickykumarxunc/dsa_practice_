package _1000;

public class _73search_in_a_row_column_row_sorted_matrix {
    public static boolean search(int matrix[][] , int target){
        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] < target){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
