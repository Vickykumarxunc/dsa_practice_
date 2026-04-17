package _1000;

import java.util.ArrayList;
import java.util.Arrays;

public class _164shop_in_candy {
    public static ArrayList<Integer> shop_in_candy(int arr[] , int n , int k){

        // first sort the array ; 
        Arrays.sort(arr);

        // 1. find the minimum amount : 
        int i = 0;
        int j = n - 1;
        int minimum = 0;
        while(i <= j){
            minimum += arr[i];
            i++;
            j -= k;
        }
        // 2. find the maximum amount : 
        i = n - 1;
        j = 0;
        int maximum = 0;
        while(j <= i){
            maximum += arr[i];
            i--;
            j += k;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(minimum);
        list.add(maximum);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
