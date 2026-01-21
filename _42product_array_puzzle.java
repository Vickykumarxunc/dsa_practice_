
import java.util.Scanner;

public class _42product_array_puzzle {
    public static int[] productExceptSelf(int arr[] , int n){

        // sabse phle suffix multiplication array bana lo : 
        int suffix[] = new int[n];
        int mul = 1;
        for(int i = n- 1; i>= 0; i--){
            mul *= arr[i];
            suffix[i] = mul;
        }
        // ab ek result array bana lo : 
        int result[] = new int[n];

        // maintain the left multiplication dynamically : 
        mul = 1;

        // traverse the array : 
        for(int i = 0; i<n - 1; i++){
            result[i] = suffix[i + 1] * mul;

            // create a prefix multiply : 
            mul *= arr[i];
        }
        // last me result par prefix mulitply put kar do : 
        result[n - 1] = mul;

        // return the result : 
        return result;
    }
    public static void print(int arr[] , int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        print(arr, n);
        int ans[] = productExceptSelf(arr, n);
        print(ans, n);
         
    }
}
