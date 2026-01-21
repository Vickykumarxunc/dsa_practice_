
import java.util.Scanner;

public class _147trailing_zero_in_factorial {
    // O(logn)
    public static int trailingZeroes(int n){

        //Trailing zeros = number of times 5 appears as a factor
        int count = 0;
        while(n != 0){
            
            n = n/5;
            count += n;
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();

        int ans = trailingZeroes(n);
        System.out.println(ans);
    }
}
