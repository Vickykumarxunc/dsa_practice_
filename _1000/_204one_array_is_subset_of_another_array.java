package _1000;
import java.util.HashSet;

public class _204one_array_is_subset_of_another_array {
    public static boolean subset(int arr1[] , int arr2[] , int n , int m){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<m; i++){
            set.add(arr2[i]);
        }
        for(int i = 0; i<n; i++){
            if(!set.contains(arr1[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
