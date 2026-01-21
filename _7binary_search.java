import java.util.Scanner;

public class _7binary_search {

    // iterative : 
    public static int search(int arr[] , int n , int target){

        // 2 pointer lo : 
        int low = 0;
        int high = n - 1;

        // loop chalao jab tak low <= high hai : 
        while(low <= high){

            // find the mid : 
            int mid = low + (high - low)/2;

            // case 1 : agar arr[mid] target ke barabar ho : 
            if(arr[mid] == target){
                return mid; 
            }
            // case 2 : agar arr[mid] target se bada ho to left side me search karo 
            else if(arr[mid] > target){
                high = mid - 1;
            }
            // case 3 : agar arr[mid] target se chota hai to right side me search karo : 
            else{
                low = mid + 1;
            }
        }
        // agar element present nahi hai to return kar do -1 : 
        return -1;
    }
    // recursive : 
    public static int binary_search(int arr[] , int left , int right , int target){

        if(left <= right){
            
            int mid = left + (right - left)/2;

            // case 1 : 
            if(arr[mid] == target){
                return mid;
            }
            // case 2 : 
            else if(arr[mid] > target){
                return binary_search(arr , left , mid - 1, target);
            }
            // case 3 : 
            else if(arr[mid] < target){
                return binary_search(arr , mid + 1 , right , target);
            }
        }
        // is element is not present in the array : 
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target element : ");
        int target = sc.nextInt();
        int ans = search(arr, n, target);
        System.out.println(ans);

         

        
    }
}
