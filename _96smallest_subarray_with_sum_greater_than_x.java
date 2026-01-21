import java.util.Scanner;

public class _96smallest_subarray_with_sum_greater_than_x {
    public static int smallest_subarray(int arr[] , int n , int target){

        // isme hum two pointer appraoch use karege : 
        int sum = 0;
        int min_length = Integer.MAX_VALUE;
        int j = 0;
        
        for(int i = 0; i<n; i++){

            sum += arr[i];

            // agar sum target se bada ho to uske nearest greater sum find karo : 
            while(sum > target){

                // update the minimum length : 
                min_length = Math.min(min_length , i - j + 1);

                // shrink the window : 
                sum -= arr[j];
                j++;
            }
        }
        if(min_length == Integer.MAX_VALUE){
            return 0;
        }
        return min_length;
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
        System.out.println("enter the subarray sum : ");
        int target = sc.nextInt();
        int ans = smallest_subarray(arr, n, target);
        System.out.println("length of the subarray sum = " + ans);

    }
}
