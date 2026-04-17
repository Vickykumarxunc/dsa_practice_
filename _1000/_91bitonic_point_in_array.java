package _1000;

public class _91bitonic_point_in_array {
    public static int bitonic_point(int arr[] , int n){
        int ans = 0;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            else{
                ans = arr[mid];
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
