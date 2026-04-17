package _1000;

import java.util.HashMap;

public class _174count_of_all_subarray_of_sum_k {
    public static int count_subarray(int arr[] , int n , int target){
        HashMap<Integer , Integer> map = new HashMap<>();
        int count = 0;
        int prefix_sum = 0;
        map.put(0 , 1);

        for(int i = 0; i<n; i++){
            prefix_sum += arr[i];
            
            if(map.containsKey(prefix_sum - target)){
                count += map.get(prefix_sum - target);
            }
            map.put(prefix_sum , map.getOrDefault(prefix_sum , 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}