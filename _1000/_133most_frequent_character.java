package _1000;
public class _133most_frequent_character {
    public static char most_frequent_character(String str , int n){
        int freq[] = new int[26];
        for(int i = 0; i<n; i++){
            freq[str.charAt(i) - 'a']++;
        }
        int max = 0;
        int index = 0;
        for(int i = 0; i<freq.length; i++){
            if(freq[i] > max){
                max = freq[i];
                index = i;
            }
        }
        return (char)(index + 'a');
    }
    public static void main(String[] args) {
        
    }
}
