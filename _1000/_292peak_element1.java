package _1000;

public class _292peak_element1 {
    public static int peak_element1(int arr[]){
        int n = arr.length;
        // apply the binary search  
        int low = 0;
        int high = n - 1;
        while(low <= high){

            // find the mid 
            int mid = low + (high - low)/2;
            
            // compare mid with left and right neighbour : 
            if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n -1 || arr[mid] > arr[mid + 1])){
                return mid; // its a peak element index 
            }
            // is peak element presnt on its right : 
            if(mid < n - 1 && arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            // if peak element present on its left : 
            else{
                high = mid - 1;
            }
        }
        // if peak element is not present : 
        return -1;
    }
    public static void main(String[] args) {
        
    } 
}
