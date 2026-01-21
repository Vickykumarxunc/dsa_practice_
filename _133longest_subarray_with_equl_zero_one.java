import java.util.HashMap;
import java.util.Scanner;
import javax.crypto.Mac;

public class _133longest_subarray_with_equl_zero_one {
    public static int longestSubarray(int arr[] , int n){

        // use the prefix sum and HashMap<sum index>
        HashMap<Integer , Integer> map = new HashMap<>();

        int sum = 0; // maintain the prefix sum: 
        int maxlen = 0; // maintain the maiximum length : 

        for(int i = 0; i<n; i++){

            // 0 replace with -1 
            sum += arr[i] == 0 ? -1 : 1;

            // agar sum zero hai : max length ko update karo : 
            if(sum == 0){
                maxlen = i + 1;
            }
            // if sum have seen before : 
            if(map.containsKey(sum)){
                maxlen = Math.max(maxlen , i - map.get(sum));
            }
            else{
                // put sum in the map with the index : 
                map.put(sum , i );
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element  : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = longestSubarray(arr, n);
        System.out.println(ans);
        
    }
}
