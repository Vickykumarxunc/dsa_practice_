package _1000;

public class _10floor_in_a_sorted_array {
    public static int floor(int arr[] , int n , int target){
        int low = 0;
        int high = n - 1;
        int floor = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                floor = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return floor;
    }
    public static void main(String[] args) {
        
    }
}
