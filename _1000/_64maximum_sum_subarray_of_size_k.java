package _1000;

public class _64maximum_sum_subarray_of_size_k {
    public static int maximum_sum_subarray_of_size_k(int arr[] , int n , int k){
        int current_sum = 0;
        for(int i = 0; i<k; i++){
            current_sum += arr[i];
        }
        int max_sum = current_sum;
        for(int i = k; i<n; i++){
            current_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum , current_sum);
        }
        return max_sum;
    }
    public static void main(String[] args) {
        
    }
}
