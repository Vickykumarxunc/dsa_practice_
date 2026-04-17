package _1000;

public class _142palindrome_number {
    public static boolean palindrome(int n){
        int m = n;
        int rev = 0;
        while(m != 0){
            rev = rev * 10 + (m % 10);
            m = m/10;
        }
        return m == n;
    }
    public static void main(String[] args) {
        
    }
}
