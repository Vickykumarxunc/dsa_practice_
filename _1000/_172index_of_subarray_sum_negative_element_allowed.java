package _1000;
import java.util.ArrayList;
import java.util.HashMap;

public class _172index_of_subarray_sum_negative_element_allowed {
    public static ArrayList<Integer> index_of_first_subarray(int arr[] , int n , int target){
       ArrayList<Integer> list = new ArrayList<>();
       HashMap<Integer , Integer> map = new HashMap<>();
       int sum = 0;
       for(int i = 0; i<n; i++){
        sum += arr[i];

        if(sum == target){
            list.add(1);
            list.add(i + 1);
            return list;
        }
        if(map.containsKey(sum - target)){
            list.add(map.get(sum - target) +2);
            list.add(i + 1);
            return list;
        }
        if(!map.containsKey(sum)){
            map.put(sum , i);
        }
       }
       list.add(-1);
       return list;
    }
    public static void main(String[] args) {
        
    }
}
