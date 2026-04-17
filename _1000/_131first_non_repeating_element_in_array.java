package _1000;

import java.util.HashMap;

public class _131first_non_repeating_element_in_array {
    public static int first_non_repeating(int arr[] , int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        for(int i = 0; i< n; i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
