package _1000;
import java.util.ArrayList;
import java.util.HashMap;

public class _176index_of_longest_subarray_with_sum_k {
    public static ArrayList<Integer> index_of_longest_subarray(int arr[] , int n , int target){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        int max_length = 0;
        int prefix_sum = 0;
        int first_index = 0;
        int second_index = 0;
        for(int i = 0; i<n; i++){

            prefix_sum += arr[i];

            if(map.containsKey(prefix_sum - target)){
                int current_length = i - map.get(prefix_sum - target);
                if(current_length > max_length){
                    first_index = map.get(prefix_sum - target) + 1;
                    second_index = i;
                }
            }
            if(!map.containsKey(prefix_sum)){
                map.put(prefix_sum , i);
            }
        }
        list.add(first_index);
        list.add(second_index);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
