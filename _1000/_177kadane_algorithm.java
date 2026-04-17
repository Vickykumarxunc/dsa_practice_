package _1000;

public class _177kadane_algorithm {
    public static int max_sum_subarray(int arr[] , int n){
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i = 0; i<n; i++){
            curr_sum += arr[i];
            max_sum = Math.max(curr_sum , max_sum);
            if(curr_sum < 0){
                curr_sum = 0;
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
        
    }
}
