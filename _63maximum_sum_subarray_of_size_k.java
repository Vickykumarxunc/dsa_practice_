import java.util.Scanner;

public class _63maximum_sum_subarray_of_size_k {
    public static int max_sum(int arr[] , int n , int k){

        int max_sum = 0;
        // phle main first window ka maximum sum nikal luga : 
        for(int i = 0; i<k; i++){
            max_sum += arr[i];
        } 
        int current_sum = max_sum;

        // ab har window ka sum max_sum se compare karuga > > > 
        for(int i = k; i<n; i++){
            current_sum = current_sum + arr[i] - arr[i - k];
            max_sum = Math.max(current_sum , max_sum);
        }
        return max_sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("enter the size of the window : ");
        int k = sc.nextInt();
        int max_sum = max_sum(arr1, n, k);
        System.out.println(max_sum);

    }
}
