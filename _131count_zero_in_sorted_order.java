
import java.util.Scanner;

public class _131count_zero_in_sorted_order {
    public static int countZero(int arr[] , int n){

        // apply the binary search : 
        // 1 1 1 0 0 0  
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == 0){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans == -1 ? 0 : n - ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans  = countZero(arr, n);
        System.out.println("no of zero =  " + ans);

    }
}
