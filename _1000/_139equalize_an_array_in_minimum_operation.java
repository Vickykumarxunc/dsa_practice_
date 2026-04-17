package _1000;

import java.util.Arrays;

public class _139equalize_an_array_in_minimum_operation {
    public static int min_operation(int arr[] , int n){
        Arrays.sort(arr);
        int median = arr[n/2];
        int count = 0;
        for(int i = 0; i<n; i++){
            count += Math.abs(arr[i] - median);
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
