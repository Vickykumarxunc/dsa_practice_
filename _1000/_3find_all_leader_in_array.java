package _1000;
import java.util.ArrayList;
import java.util.Collections;

public class _3find_all_leader_in_array {
    public static ArrayList<Integer> all_leader(int arr[] , int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[n - 1]);
        int leader = arr[n - 1];
        for(int i = n - 2; i>= 0; i--){
            if(arr[i] > leader){
                leader = arr[i];
                list.add(leader);
            }
        }
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
