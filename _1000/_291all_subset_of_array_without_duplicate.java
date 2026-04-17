package _1000;

import java.util.Arrays;
import java.util.ArrayList;

public class _291all_subset_of_array_without_duplicate {
    public static void find(int arr[] , int idx , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list){

        // every recursive function call create a new list which is a new subset 
        ans.add(new ArrayList<>(list));
        for(int i = idx; i<arr.length; i++){
            // avoid duplicate : 
            if(i != idx && arr[i] == arr[i - 1]){
                continue;
            }
            list.add(arr[i]);
            find(arr , i + 1 , ans , list);

            // back track : 
            list.remove(list.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> subset(int arr[]){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        find(arr , 0 , ans , list);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
