package _1000;

public class _15palindrome_string {
    public static boolean palindrome_string(String str , int n){
        for(int i = 0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
