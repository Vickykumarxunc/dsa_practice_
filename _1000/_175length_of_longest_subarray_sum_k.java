package _1000;
import java.util.HashMap;

public class _175length_of_longest_subarray_sum_k {
    public static int longest_subarray(int arr[] , int n , int target){
        HashMap<Integer , Integer> map = new HashMap<>();
        int max_length = 0;
        int prefix_sum = 0;
        map.put(0 , -1);
        for(int i = 0; i<n; i++){
            
            prefix_sum += arr[i];

            if(map.containsKey(prefix_sum - target)){
                max_length = Math.max(max_length , i - map.get(prefix_sum - target));
            }
            if(!map.containsKey(prefix_sum)){
                map.put(prefix_sum , i);
            }
        }
        return max_length;
    }
    public static void main(String[] args) {
        
    }
}
