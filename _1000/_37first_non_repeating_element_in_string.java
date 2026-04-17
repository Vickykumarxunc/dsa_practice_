package _1000;

public class _37first_non_repeating_element_in_string {
    public static char first_non_repeatingcharacter(String str , int n){
        int freq[] = new int[26];
        for(int i = 0; i<n; i++){
            freq[str.charAt(i) - 'a']++;
        }
        for(int i = 0; i<n; i++){
            if(freq[str.charAt(i) - 'a'] == 1){
                return str.charAt(i);
            }
        }
        return '#';
    }
    public static void main(String[] args) {
        
    }
}
