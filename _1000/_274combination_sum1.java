package _1000;
import java.util.ArrayList;

public class _274combination_sum1 {
    // time : 2^t * k
    public static void combination(int arr[] , int idx , int target , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> list){

        // base case 
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // pick 
        if(arr[idx] <= target){

            list.add(arr[idx]);
            combination(arr , idx , target - arr[idx] , ans , list);

             // back track : 
            list.remove(list.size() - 1);
        }
        // not pick : 
        combination(arr , idx + 1 , target , ans , list);
    }
    public static void main(String[] args) {
        int arr[] = {2 , 3 , 6 , 7};
        int target = 7;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        combination(arr, 0 , target, ans, list);
        System.out.println(ans);
    }
}
