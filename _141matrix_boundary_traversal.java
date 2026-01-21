
import java.util.Scanner;
import java.util.ArrayList;

public class _141matrix_boundary_traversal {
    public static ArrayList<Integer> boundary_traversal(int matrix[][] , int r , int c){
        ArrayList<Integer> ans = new ArrayList<>();

        // top row : 
        for(int j = 0; j<c; j++){
            ans.add(matrix[0][j]);
        }
        // right column : 
        for(int i = 1; i<r; i++){
            ans.add(matrix[i][c - 1]);
        }
        // bottom row : 
        for(int j = c - 2; j >= 0; j--){
            ans.add(matrix[r - 1][j]);
        }
        // left column : 
        for(int i = r - 2; i > 0; i--){
            ans.add(matrix[i][0]);
        }
        return ans;
    }
    public static void print(int matrix[][] , int r , int c){
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row ;");
        int row = sc.nextInt();
        System.out.println("Enter the column : ");
        int col = sc.nextInt();
        System.out.println("enter the matrix element : ");
        int matrix[][] = new int[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        print(matrix, row, col);
        ArrayList<Integer> ans = boundary_traversal(matrix, row, col);
        System.out.println(ans);
    }
}
