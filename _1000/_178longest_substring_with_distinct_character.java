package _1000;
import java.util.HashSet;

public class _178longest_substring_with_distinct_character {
    public static int substring(String str , int n){
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max_length = 0;
        while(right < n){
            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                max_length = Math.max(max_length , right - left + 1);
                right++;
            }
            else{
                set.remove(str.charAt(left));
                left++;
            }
        }
        return max_length;
    }
    public static void main(String[] args) {
        
    }
}
