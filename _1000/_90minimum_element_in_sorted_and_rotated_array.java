package _1000;

public class _90minimum_element_in_sorted_and_rotated_array {
    public static int minimum(int arr[] , int n){
        int ans = 0;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[n - 1]){
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
