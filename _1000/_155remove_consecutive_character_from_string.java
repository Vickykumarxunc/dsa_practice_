package _1000;

public class _155remove_consecutive_character_from_string {
    public static String remove(String str , int n){
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        for(int i = 1; i<n; i++){
            if(str.charAt(i) != str.charAt(i - 1)){
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        
    }
}
