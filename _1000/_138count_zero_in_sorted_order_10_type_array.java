package _1000;

public class _138count_zero_in_sorted_order_10_type_array {
    public static int count_zero(int arr[] , int n){
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == 1){
                low = mid + 1;
            }
            else{
                high = mid - 1;
                ans = mid;
            }
        }
        return ans == -1 ? 0 : n - ans;
    }
    public static void main(String[] args) {
        
    }
}
