package _1000;

import java.util.TreeMap;

public class _270most_frequent_even_element {
    public static int most_frequent_element(int arr[] , int n){

        // tree map use to avoid conflict 
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0; i<n; i++){
            if(arr[i] % 2 == 0){
                map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
            }
        }
        int ans = -1;
        int max_freq = -1;
        for(int key : map.keySet()){
            if(map.get(key) > max_freq){
                max_freq = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
