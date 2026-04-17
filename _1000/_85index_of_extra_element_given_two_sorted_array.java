package _1000;

public class _85index_of_extra_element_given_two_sorted_array {
    public static int find(int arr1[] , int arr2[] , int n , int m){
        int low = 0;
        int high = m;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr1[mid] == arr2[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;  
            }
        }
        // index of the extra element : 
        return low;
    }
    public static void main(String[] args) {
        
    }
}
