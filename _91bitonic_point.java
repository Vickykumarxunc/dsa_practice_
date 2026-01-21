
import java.util.Scanner;

public class _91bitonic_point {
    public static int bitonic_point(int arr[] , int n){

        int low = 0;
        int high = n - 1;

        while(low <= high){
            
            int mid = low + (high - low)/2;

            // condition of the peak element : 
            if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])){
                return arr[mid];
            }
            // right side me peak element present hai : 
            else if(mid < n - 1 && arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            // left side me peak element present hai : 
            else{
                high =  mid - 1;
            }
        }
        return -1;
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
        int ans = bitonic_point(arr, n);
        System.out.println(ans);


    }
}
