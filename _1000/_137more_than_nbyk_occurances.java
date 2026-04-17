package _1000;
import java.util.HashMap;

public class _137more_than_nbyk_occurances {
    public static int count(int arr[] , int n , int k){
        HashMap<Integer , Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > n/k){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
