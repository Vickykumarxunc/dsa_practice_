package DP.recursion;
import java.util.ArrayList;
public class _11print_subsequences_whose_sum_k {
    public static void subsequences(int arr[] , int idx , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list , int sum , int k){
        if(idx >=  arr.length){
            if(sum == k){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // take : 
        list.add(arr[idx]);
        sum += arr[idx];
        
        subsequences(arr , idx + 1 , ans , list , sum, k);
        // not take : 
        list.remove(list.size() - 1);
        sum -= arr[idx];

        subsequences(arr , idx + 1 , ans , list , sum , k);
    }
    public static void main(String[] args) {
        int arr[] = {1 , 2 , 1};
        int sum = 0;
        int k = 2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsequences(arr, 0, ans, list, sum, k);

    }
}
