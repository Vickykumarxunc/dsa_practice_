package _1000;

import java.util.HashMap;

public class _84find_all_pair_with_given_sum_from_two_array {
    public static int count(int arr1[] , int arr2[] , int n , int m , int target){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr1[i] , map.getOrDefault(arr1[i] , 0) + 1);
        }
        int count = 0;
        for(int i = 0; i<m; i++){
            int need = target - arr2[i];
            if(map.containsKey(need)){
                count += map.get(need);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
