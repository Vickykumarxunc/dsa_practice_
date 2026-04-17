package _1000;
import java.util.ArrayList;
import java.util.HashMap;

public class _103group_anagram {
    public static ArrayList<ArrayList<String>> group(String str[] , int n){
        HashMap<String , ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            int freq[] = new int[26];
            String s = str[i];

            for(int j = 0; j<s.length(); j++){
                char ch = s.charAt(i);
                freq[ch - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int k = 0; k<26; k++){
                key.append(freq[k]).append('#');
            }
            if(!map.containsKey(key.toString())){
                map.put(key.toString() , new ArrayList<>());
            }
            map.get(key.toString()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        
    }
}
