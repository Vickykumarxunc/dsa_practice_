package _1000;
import java.util.HashSet;

public class _19two_sum_pair_given_sum_present_in_array_or_not {
    public static boolean pair_sum(int arr[] , int n , int target){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            if(set.contains(target - arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
