package _1000;
import java.util.ArrayList;
import java.util.HashSet;

public class _13union_of_two_array {
    public static ArrayList<Integer> union_of_2_array(int arr1[] , int arr2[] , int n , int m){
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int element : arr1){
            set.add(element);
        }
        for(int element : arr2){
            set.add(element);
        }
        for(int i : set){
            list.add(i);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
