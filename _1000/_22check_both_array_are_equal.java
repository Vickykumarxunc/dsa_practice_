package _1000;

import java.util.HashMap;

public class _22check_both_array_are_equal {
    public static boolean check_equal(int arr1[] , int arr2[] , int n , int m){
        if(n != m){
            return false;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr1[i] , map.getOrDefault(arr1[i] , 0) + 1);
        }
        for(int i = 0; i<m; i++){
            if(!map.containsKey(arr2[i]) || map.get(arr2[i]) == 0){
                return false;
            }
            map.put(arr2[i] , map.get(arr2[i]) - 1);
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}
