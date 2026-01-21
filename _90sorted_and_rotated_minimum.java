
import java.util.Scanner;

public class _90sorted_and_rotated_minimum {
    public static int findMin(int arr[] , int n){
        // hum is par binary search apply kr sakte hai : 
        int low = 0;
        int high = n - 1;
        int ans = 0;
    
        while(low <= high){
            
            int mid = low + (high - low)/2;

            // bar bar mid element ko last element se compare karke dekhege : 
            // agar mid element last element se chota hai to ans ko update kar do : 
            // end = mid - 1; 
            if(arr[mid] <= arr[n - 1]){
                ans = arr[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = findMin(arr, n);
        System.out.println("minimum element in the array = " + ans);
    }
    
}
/*
A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 
 */
