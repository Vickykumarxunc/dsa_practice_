package DP.recursion;

public class _8palindrome_string {
    public static boolean palindrome(String str , int i , int n){
        if(i >= n/2){
            return true;
        }
        if(str.charAt(i) != str.charAt(n - i - 1)){
            return false;
        }
        return palindrome(str , i , n);
    }
    public static void main(String[] args) {
        
    }
}
