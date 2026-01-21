import java.util.Scanner;

public class _168kadanes_algorithm {
    public static int max_sum_subarray(int arr[] , int n){

        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i = 0; i<n; i++){
            
            curr_sum += arr[i];
            max_sum = Math.max(max_sum , curr_sum);

            if(curr_sum < 0){
                curr_sum = 0;
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = max_sum_subarray(arr, n);
        System.out.println("maximum sum = " + ans);
    }
}
