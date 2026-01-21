
import java.util.Scanner;

public class _12count_digit {
    public static int count(int n){
        int count = 0;
        // store the original number into another number : 
        int m = n;
        while(n != 0){
            int rem = n % 10;
            if(m % rem == 0){
                count++;
            }
            // update the number : 
            n = n/10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number : ");
        int n = sc.nextInt();
        int ans = count(n);
        System.out.println("count = " + ans);

    }
}
/*
Given a positive integer n, count the number of digits in n that divide n evenly (i.e., without leaving a remainder). Return the total number of such digits.

A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).
Digits of n should be checked individually. If a digit is 0, it should be ignored because division by 0 is undefined.

Input: n = 12
Output: 2
Explanation: 1, 2 when both divide 12 leaves remainder 0.
 */
