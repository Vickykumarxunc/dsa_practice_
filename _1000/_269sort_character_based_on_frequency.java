package _1000;
import  java.util.HashMap;
import java.util.PriorityQueue;

public class _269sort_character_based_on_frequency {
    public static String sortCharacter(String str , int n){

        // create hashMap to store frequency : 
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            char ch = str.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        // create a max heap : 
        PriorityQueue<Character> pq = new PriorityQueue<>((a , b)-> map.get(b) - map.get(a));
        for(char key : map.keySet()){
            pq.add(key);
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int freq = map.get(ch);
            
            while(freq-- > 0){
                ans.append(ch);
            }
        }
        return new String(ans);
    }
    public static void main(String[] args) {
        
    }
}
