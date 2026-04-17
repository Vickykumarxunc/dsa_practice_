package _1000;
import java.util.ArrayList;
import java.util.HashSet;

public class _57intersection_of_two_array {
    public static ArrayList<Integer> intersection(int arr1[] , int arr2[] , int n , int m){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i<m; i++){
            if(set.contains(arr2[i])){
                list.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
