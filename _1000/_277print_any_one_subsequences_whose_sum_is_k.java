package _1000;

import java.util.ArrayList;

public class _277print_any_one_subsequences_whose_sum_is_k {
    public static boolean find_subsequences(int arr[] , int idx , ArrayList<Integer> list , int sum , int target){
        
        // base condtion : 
        if(idx == arr.length){
            if(sum == target){
                return true;
            }
            else return false;
        }
        // take : 
        sum += arr[idx];
        list.add(arr[idx]);
        if(find_subsequences(arr , idx + 1 , list , sum , target)){
            return true;
        }
        // back track : 
        sum -= arr[idx];
        list.remove(list.size() - 1);

        // not take : 
        if(find_subsequences(arr , idx + 1 , list , sum , target)){
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> subsequences(int arr[] , int target){
        ArrayList<Integer> list = new ArrayList<>();
        find_subsequences(arr , 0 , list , 0 , target);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
