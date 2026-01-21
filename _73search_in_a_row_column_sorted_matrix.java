
import java.util.Scanner;
public class _73search_in_a_row_column_sorted_matrix {
    public static boolean search(int matrix[][] , int target){

        // here we apply the binary search 
        // using the two pointer : 
        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0){

            if(matrix[i][j] == target){
                return true;
            }
            // agli row par chale jao : 
            else if(matrix[i][j] < target){
                i++;
            }
            // same row me ek column peeche aa jao : 
            else{
                j--;
            }
        }
        // agar element matrix me present nahi hai return false : 
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the row : ");
        int r = sc.nextInt();
        System.out.println("enter the size of the column : ");
        int c = sc.nextInt();

        System.out.println("enter the element in matrix : ");
        int matrix[][] = new int[r][c];

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the target element : ");
        int target =  sc.nextInt();

        boolean ans = search(matrix, target);
        System.out.println("element is present or not = " + ans);

    }
}

// time complexity = O(n + m) 
/*
Har step me ya to ek row eliminate hoti hai (i++)
👉 ya ek column eliminate hota hai (j--)
👉 Maximum moves = n + m
 */
