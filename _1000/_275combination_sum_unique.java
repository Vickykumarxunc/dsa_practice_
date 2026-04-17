package _1000;
import java.util.ArrayList;

public class _275combination_sum_unique {
    public static void findCombination(int arr[] , int idx , int target , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list){

        // base case : 
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        // check the all other possibility : 
        for(int i = idx; i<arr.length; i++){

            // avoid contiguous duplicate : 
            if(i > idx && arr[i] == arr[i - 1]){
                break;
            }
            list.add(arr[i]);
            findCombination(arr, i + 1, target - arr[i], ans, list);
            list.remove(list.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum2(int arr[] , int target , int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        findCombination(arr , 0 , target , ans , list);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
