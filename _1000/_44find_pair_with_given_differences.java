package _1000;
import java.util.Arrays;
import java.util.HashSet;

public class _44find_pair_with_given_differences {
    public static boolean find_pair(int arr[] , int n , int target){
        Arrays.sort(arr);
        int low = 0;
        int high = 1;
        while(low < n && high < n){
            int diff = arr[high] - arr[low];
            if(diff == target){
                return true;
            }
            else if(diff > target){
                low++;
            }
            else{
                high++;
            }
            if(low == high){
                high++;
            }
        }
        return false;
    }
    public static boolean difference(int arr[] , int target , int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(set.contains(arr[i] - target) || set.contains(arr[i] + target)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
