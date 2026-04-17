package _1000;

public class _38find_kth_rotation {
    public static int find_kth_rotation(int arr[] , int n){
        int ans  = 0;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[n - 1]){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
