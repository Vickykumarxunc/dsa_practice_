package DP.recursion;
import java.util.ArrayList;

public class _12print_any_one_subsequences_whose_sum_k {
    public static boolean subsequences(int arr[] , ArrayList<Integer>list , int idx , int sum , int k){
        if(idx == arr.length){
            if(sum == k){
                System.out.println(list);
                return true;
            }
            else{
                return false;
            }
        }
        // take : 
        list.add(arr[idx]);
        sum += arr[idx];

        // jaise hi answer mile break not further recursion call 
        if(subsequences(arr, list, idx, sum, k)){
            return true;
        }
        // back track : 
        list.remove(list.size() - 1);
        sum -= arr[idx];

        // not take 
        // jaishe hi answer mile break not further recursive call : 
        if(subsequences(arr, list, idx, sum, k)){
            return true;
        }
        // agar anwer nahi mile : 
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1 , 2 , 1};
        int sum = 0;
        int k = 2;
        ArrayList<Integer> list = new ArrayList<>();
        subsequences(arr, list, 0, sum, k);
    }
}
