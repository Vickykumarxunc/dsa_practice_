package _1000;

import java.util.HashMap;

public class _141count_subarray_wth_equal_zero_and_one {
    public static int count(int arr[] , int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(sum == 0){
                count++;
            }
            if(map.containsKey(sum)){
                count+= map.get(sum);
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
