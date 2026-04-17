package DP.recursion;
import java.util.ArrayList;

public class _10print_subsequences {
    // time complexity: n * 2^n
    // space : n
    public static void printsubsequence(int arr[] , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list , int idx){
        if(idx >= arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // take : 
        list.add(arr[idx]);
        printsubsequence(arr, ans, list, idx + 1);
        // not take : 
        list.remove(list.size() - 1);
        printsubsequence(arr, ans, list, idx + 1);
    }
    public static void main(String[] args) {
        int arr[] = {3 , 1 , 2};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        printsubsequence(arr , ans , list , 0);
        System.out.println(ans);
    }
}
