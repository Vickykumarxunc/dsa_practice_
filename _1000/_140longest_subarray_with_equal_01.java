package _1000;

import java.util.HashMap;

public class _140longest_subarray_with_equal_01 {
    public static int longest_subarray_with_equal_zero_one(int arr[] , int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int max_length = 0;
        
        // first convert the all zero to -1 
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        for(int i = 0; i<n; i++){

            // prefix sum : 
            sum += arr[i];

            if(sum == 0){
                max_length = i + 1;
            }
            if(map.containsKey(sum)){
                max_length = Math.max(max_length , i - map.get(sum));
            }
            else{
                map.put(sum , i);
            }
        }
        return max_length;
    }
    public static void main(String[] args) {
        
    }
}
