import java.util.Scanner;

public class _135transpose_matrix {
    public static int[][] traspose(int matrix[][] , int n , int m){
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
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
    System.out.println("Enter the size of the row : ");
    int r = sc.nextInt();
    System.out.println("enter the size of column : ");
    int c = sc.nextInt();
    System.out.println("enter the matrix element : ");
    int matrix[][] = new int[r][c];
    for(int i = 0; i<r; i++){
        for(int j = 0; j<c; j++){
            matrix[i][j] = sc.nextInt();
        }
    }   
    print(matrix , r , c);
    int ans[][] = traspose(matrix, r, c);
    print(ans , r , c);

   } 
}
