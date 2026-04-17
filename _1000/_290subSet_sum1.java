package _1000;
import java.util.ArrayList;
import java.util.Collections;

public class _290subSet_sum1 {
    public static void subset(int arr[] , ArrayList<Integer> list , int idx , int sum){
        // base case : 
        if(idx == arr.length){
            list.add(sum);
            return;
        }
        // pick : 
        sum += arr[idx];
        subset(arr , list , idx + 1 , sum);

        // dont pick : 
        sum -= arr[idx];
        subset(arr , list , idx + 1 , sum);
    }
    // time complexity : 2^n : 
    public static ArrayList<Integer> subsetSum(int arr[] , int n){
        ArrayList<Integer> subset = new ArrayList<>();
        subset(arr , subset , 0 , 0);
        Collections.sort(subset);
        return subset;
    }
    public static void main(String[] args) {
        
    }
}
