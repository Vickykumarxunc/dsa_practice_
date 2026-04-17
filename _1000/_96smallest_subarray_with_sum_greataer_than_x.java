package _1000;

public class _96smallest_subarray_with_sum_greataer_than_x {
    public static int smallest_subarray(int arr[] , int n , int target){
        int dist = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];

            while(sum > target){
                dist = Math.min(dist , i - j + 1);
                sum -= arr[j];
                j++;    
            } 
        }
        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
    public static void main(String[] args) {
        
    }
}
