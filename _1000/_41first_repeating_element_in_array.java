package _1000;

import java.util.HashSet;

public class _41first_repeating_element_in_array {
    public static int first_repeating(int arr[] , int n){
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = n - 1; i>= 0; i--){
            if(set.contains(arr[i])){
                ans = arr[i];
            }
            set.add(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
