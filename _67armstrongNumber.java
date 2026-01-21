
import java.util.Scanner;

public class _67armstrongNumber {
    public static boolean armStrong(int n){

        int m = n;
        int arm = 0;
        while(m != 0){
            int rem = m % 10;
            arm += rem * rem * rem;
            m = m/10;
        }
        return arm == n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();

        boolean ans = armStrong(n);
        System.out.println("number is armstrong or not = " + ans);

    }
}
