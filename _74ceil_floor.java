
import java.util.Scanner;

public class _74ceil_floor {
    public static int[] getfloorAndCeil(int arr[] ,int n , int target){

        int floor = -1;
        int ceil = -1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){

            // for the floor : 
            if(arr[i] > min && arr[i] <= target){
                 min = arr[i];
                 floor = min;
            }
            if(arr[i] < max && arr[i] >= target){
                 max = arr[i];
                 ceil = max;
            }
        }
        int ans[] = new int[]{floor , ceil};
        return ans;
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
        System.out.println("enter the target : ");
        int target = sc.nextInt();
        int ans[] = getfloorAndCeil(arr, n, target);
        System.out.println("floor = " + ans[0]);
        System.out.println("ceil = " + arr[1]);

    }
}
