package _1000;
public class _245search_insert_position{
    public static int find_position(int arr[] , int n , int target){
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            // agar target element array me present hai to uska index return kar do : 
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        // warn uska future index return karo jis par vo insert ho sakta hai: 
        return low;
    }
    public static void main(String args[]){

    }
}