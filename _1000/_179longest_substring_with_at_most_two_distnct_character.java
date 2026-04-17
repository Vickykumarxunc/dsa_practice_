package _1000;
import java.util.HashMap;

public class _179longest_substring_with_at_most_two_distnct_character {
    public static int longest_substring(String str , int n){
        HashMap<Character , Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max_length = 0;
        while(right < 0){
            char ch = str.charAt(right);
            map.put(ch , map.getOrDefault(ch,0) + 1);

            // shrink the window until map has at most 2 distinct character :
            while(map.size() > 2){
                char left_char = str.charAt(left);
                map.put(left_char , map.get(left_char) - 1);
                if(map.get(left_char) == 0){
                    map.remove(left_char);
                }
                left++;
            }
            max_length = Math.max(max_length , right - left + 1);
        }
        return max_length;
    }
    public static void main(String[] args) {
        
    } 
}
