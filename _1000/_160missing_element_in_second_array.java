package _1000;
import java.util.ArrayList;
import java.util.HashMap;

public class _160missing_element_in_second_array {
    public static ArrayList<Integer> missing_element_in_second_array(int arr1[] , int arr2[] , int n , int m){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<m; i++){
            map.put(arr2[i] , map.getOrDefault(arr2[i] , 0) + 1);
        }
        for(int i = 0; i<n; i++){
            if(!map.containsKey(arr1[i])){
                list.add(arr1[i]);
            }
            else{
                map.put(arr1[i] , map.get(arr1[i]) - 1);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
