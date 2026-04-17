package _1000;

public class _7binary_search {
    public static boolean binary_search1(int arr[] , int n , int target){
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
    public static boolean binary_search2(int arr[] , int low , int high , int target){
        if(low > high){
            return false;
        }
        int mid = low + (high - low)/2;
        if(arr[mid] == target){
            return true;
        }
        else if(arr[mid] < target){
            return binary_search2(arr, mid + 1, high, target);
        }
        else{
            return binary_search2(arr, low, mid - 1, target);
        }

    }
    public static void main(String[] args) {
        
    }
}
