package _1000;

import java.util.ArrayList;

public class _279print_all_subsequences {
    public static void find_subsequences(int arr[] , int idx , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list){
        
        // base case : 
        if(idx == arr.length - 1){
            ans.add(new ArrayList<>(list));
            return;
        }
        // take : 
        list.add(arr[idx]);
        find_subsequences(arr, idx + 1, ans, list);

        // back track : 
        list.remove(list.size() - 1);

        // not  take : 
        find_subsequences(arr, idx + 1, ans, list);
    }
    public static ArrayList<ArrayList<Integer>> subsequences(int arr[] , int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        find_subsequences(arr , 0 , ans , list);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
