package _1000;

import java.util.TreeMap;

public class _166winner_of_election {
    public static String[] winner_of_election(String arr[] , int n){
        // use the tree map 
        // ye string ko lexicographically store karege : 
        TreeMap<String , Integer> map = new TreeMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        String ans = "";
        int max_vote = 0;
        
        for(String key : map.keySet()){
            if(map.get(key) > max_vote){
                max_vote = map.get(key);
                ans = key;
            }
        }
        String winner[] = {ans , ""+max_vote};
        return winner;
    }
    public static void main(String[] args) {
        
    }
}
