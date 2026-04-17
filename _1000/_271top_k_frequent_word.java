package _1000;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

public class _271top_k_frequent_word {
    public static ArrayList<String> topkFrequent(String word[] , int k){
        int n = word.length;
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(word[i] , map.getOrDefault(word[i] , 0) + 1);
        }
        // min heap based on frequency with lowest word length 
        // largest word length pop first : 
        PriorityQueue<String> pq = new PriorityQueue<>((a , b)->{
             if(map.get(a).equals(map.get(b))){
                return b.compareTo(a); // reverse lexicographically largest word 
             }
             return map.get(a) - map.get(b);
        });

        for(String key : map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
