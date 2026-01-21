
import java.util.Scanner;

public class _134palindrome_number {
    public static boolean check_palindrome(int n){
        int m = n;
        int rev = 0;
        while(m != 0){
            int rem = m % 10;
            rev = rev * 10 + rem;
            m = m/10;
        }
        return rev == n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();
        boolean ans = check_palindrome(n);
        System.out.println(ans);
    }
}
