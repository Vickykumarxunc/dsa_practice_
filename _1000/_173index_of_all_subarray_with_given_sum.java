package _1000;
import java.util.ArrayList;
import java.util.HashMap;

public class _173index_of_all_subarray_with_given_sum {

    public static ArrayList<ArrayList<Integer>> index_of_subarray(int arr[] , int n , int target){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        int curr_sum = 0;
        for(int i = 0; i<n; i++){
            curr_sum += arr[i];

            if(map.containsKey(curr_sum - target)){
                for(int index : map.get(i)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(index + 1);
                    temp.add(i + 1);
                    list.add(temp);
                }
            }
            if(!map.containsKey(curr_sum)){
                map.put(curr_sum , new ArrayList<>());
                map.get(curr_sum).add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
