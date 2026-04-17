package _1000;

import java.util.ArrayList;

public class _276print_subsequences_whose_sum_k {
    public static void find_subsequences(int arr[] , int idx , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list , int sum , int target){
        // base condition : 
        if(idx == arr.length - 1){
            if(sum == target){
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        // take : 
        list.add(arr[idx]);
        sum += arr[idx];
        find_subsequences(arr , idx + 1 , ans , list , sum , target);

        // back track 
        list.remove(list.size() - 1);
        sum -= arr[idx];

        // not take : 
        find_subsequences(arr , idx + 1 , ans , list , sum , target);
    }
    public static ArrayList<ArrayList<Integer>> subsequences(int arr[] , int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        find_subsequences(arr , 0 , ans , list , 0 , target);
        return ans;
    }
    public static void main(String args[]){

    }
}
