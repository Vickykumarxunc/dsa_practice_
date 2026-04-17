package _1000;

public class _30no_of_occrances_of_given_number_in_sorted_array {
    public static int no_of_occurances(int arr[] , int target , int n){
        int first = first_occrances(arr , target , n);
        int last = last_occurances(arr , target , n);
        return first == -1 ? -1 : last - first + 1;
    }
    public static int first_occrances(int arr[] , int target , int n){
        int low = 0;
        int high = n - 1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return first;
    }
    public static int last_occurances(int arr[] , int target , int n){
        int low = 0;
        int high = n - 1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        
    }
}
