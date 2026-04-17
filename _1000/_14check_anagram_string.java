package _1000;
import java.util.HashMap;
public class _14check_anagram_string {
    public static boolean check_anagram(String str1 , String str2 , int n , int m){
        if(n != m){
            return false;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(str1.charAt(i) , map.getOrDefault(str1.charAt(i) , 0) + 1);
        }
        for(int i = 0; i<m; i++){
            if(!map.containsKey(str2.charAt(i)) || map.get(str2.charAt(i)) == 0){
                return false;
            }
            map.put(str2.charAt(i) , map.get(str2.charAt(i)) - 1);
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
