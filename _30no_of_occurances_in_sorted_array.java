
import java.util.Scanner;

public class _30no_of_occurances_in_sorted_array {
    public static int first_index(int arr[] , int n , int target){
        int low = 0;
        int high = n - 1;
        int first = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid - 1; //mujhe or chota index mil sakta hai : 
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
    public static int last_index(int arr[] , int n , int target){
        int low = 0;
        int high = n - 1;
        int last = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1; // mujhe or bada index mil sakta hai : 
            }
            else if(arr[mid] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return last;
    }
    public static int occurances(int arr[] , int n , int target){

        // first find the first index of the element and last index of the element : 
        int first = first_index(arr , n , target);
        int last = last_index(arr , n , target);

        // check element is present or not 
        if(first == -1){
            return 0; // element is not present : so number of occurances is 0 : 
        } 
        return last - first + 1;
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
        System.out.println("enter the target : ");
        int target = sc.nextInt();

        int ans = occurances(arr, n, target);
        System.out.println("no of occurances = " + ans);

    }
}
