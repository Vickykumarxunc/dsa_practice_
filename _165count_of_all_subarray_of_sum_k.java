import java.util.HashMap;
import java.util.Scanner;

public class _165count_of_all_subarray_of_sum_k {
    // negative number : 
    public static int count_subarray(int arr[] , int target , int n){

        // use the prefix sum and hashmap to handle the negative cases : 
        HashMap<Integer , Integer> map = new HashMap<>();
        int count = 0;
        int curr_sum = 0;
        for(int i = 0; i<n; i++){

            curr_sum += arr[i];
            
            if(map.containsKey(curr_sum - target)){
                count += map.get(curr_sum - target);
            }
            map.put(curr_sum , map.getOrDefault(curr_sum , 0 ) + 1);
        }
        return count;
    }
    // positive number  : 
    public static int count(int arr[] , int target , int n){
        
        // use the sliding window : 
        int j = 0;
        int count = 0;
        int curr_sum = 0;
        for(int i = 0; i<n; i++){

            curr_sum += arr[i];

            while(j < i && curr_sum > target){
                curr_sum -= arr[j];
                j++;
            }
            if(curr_sum == target){
                count++;
            }
        }
        return count;
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

        int ans = count_subarray(arr, target, n);
        System.out.println("no of subarray = " + ans);

    }
}
