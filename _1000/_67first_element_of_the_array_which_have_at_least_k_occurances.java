package _1000;

import java.util.HashMap;

public class _67first_element_of_the_array_which_have_at_least_k_occurances {
    public static int first_element(int arr[] ,int n , int k){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        for(int i = 0; i<n; i++){
            if(map.get(arr[i]) >= k){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
