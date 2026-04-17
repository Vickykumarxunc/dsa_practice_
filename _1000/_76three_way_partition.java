package _1000;

public class _76three_way_partition {
    // dutch national flag : 
    public static void three_way_partition(int arr[] , int n , int a , int b){
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while(mid <= high){
            if(arr[mid] < a){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] > b){
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
            // in range
            else{
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
