
import java.util.Scanner;

public class _38find_kth_rotation {
    public static int find(int arr[] , int n){

        // jo minimum element ka index hoga array utni hi baar rotate hua hoga  : 
        // to hame minimum element ka index nikalna hai binary search ki help se : 
        int ans = 0;
        int low = 0;
        int high = n - 1;

        while(low <= high){

            int mid = low + (high - low)/2;

            // agar current element high se chota hai matlab smallest mid ki left side me present hai : 
            if(arr[mid] <= arr[n - 1]){
                ans = mid; // to hum apane ans ko update kar de ge ki ye possible ans ho sakta hai : 
                high = mid - 1;
            }
            // minimum right side me hai : 
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

        int ans = find(arr, n);
        System.out.println("how many time array rotate = " + ans);

    }
}
