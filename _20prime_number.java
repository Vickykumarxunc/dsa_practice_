
import java.util.Scanner;

public class _20prime_number {
    public static boolean isPrime(int n){
        if(n == 1 || n == 0){
            return false;
        }
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number: ");
        int n = sc.nextInt();
        boolean ans = isPrime(n);
        System.out.println("is prime or not = " + ans);

    }
}
