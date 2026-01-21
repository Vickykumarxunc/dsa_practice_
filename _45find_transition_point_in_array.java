
import java.util.Scanner;

public class _45find_transition_point_in_array {
    public static int transitionPoint(int arr[] , int n){

        // apply the binary search : 
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] == 0){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
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
        int ans = transitionPoint(arr, n);
        System.out.println("transition point = " + ans);

    }
}
/*
Given a sorted array, arr[] containing only 0s and 1s, find the transition point, i.e., the first index where 1 was observed, and before that, only 0 was observed.  If arr does not have any 1, return -1. If array does not have any 0, return 0.
 */
