package _1000;

public class _254first_repeating_character_of_a_string {
    public static char first_repeating_character(String str , int n){
        int freq[] = new int[26];
        for(int i = 0; i<n; i++){
            freq[str.charAt(i)]++;
        }
        for(int i = 0; i<n; i++){
            if(freq[str.charAt(i)] > 1){
                return str.charAt(i);
            }
        }
        return '#';
    }
    public static void main(String[] args) {
        
    }
}
