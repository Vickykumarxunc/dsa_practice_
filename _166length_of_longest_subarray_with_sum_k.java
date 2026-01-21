import java.util.HashMap;
import java.util.Scanner;

public class _166length_of_longest_subarray_with_sum_k {
    public static int longestSubarray(int arr[] , int target , int n){

        // use the hashMap and prefix sum to handle the negative case : 
        HashMap<Integer , Integer> map = new HashMap<>();
        int curr_sum = 0;
        int max_length = 0;

        for(int i = 0; i<n; i++){

            curr_sum += arr[i];

            // subarray startfrom the index 0 : 
            if(curr_sum ==target){
                 max_length = i + 1;
            }
            // agar subarray middle me hai : 
            if(map.containsKey(curr_sum - target)){
                max_length = Math.max(max_length , i - map.get(curr_sum - target));
            }
            // agar current sum map me prsent nahi hai :
            // always we store the first occurances of the prefix sum :  
            if(!map.containsKey(curr_sum)){
                map.put(curr_sum , i);
            }
        }
        return max_length;
    }
    // for the positive number : 
    public static int longest_subarray(int arr[] , int target , int n){

        // use the sliding window 
        int j = 0;
        int curr_sum = 0;
        int max_length = 0;
        for(int i = 0; i<n; i++){

            curr_sum += arr[i];

            while(j < i && curr_sum > target){
                curr_sum -= arr[j];
                j++;
            }
            if(curr_sum == target){
                max_length = Math.max(max_length , i - j + 1);
            }
        }
        return max_length;
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
        System.out.println("enter the target sum : ");
        int target = sc.nextInt();

        int ans = longestSubarray(arr, target, n);
        System.out.println("length of the longest subarray : = " + ans);

    }

}
