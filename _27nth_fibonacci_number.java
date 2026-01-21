
import java.util.Scanner;

public class _27nth_fibonacci_number {
    public static int nth_fibonacci_number(int n){
        
        // base case : 
        if(n == 0 || n == 1){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();
        int ans = nth_fibonacci_number(n);
        System.out.println("nth fibonacci number = " + ans);
        
    }
}
