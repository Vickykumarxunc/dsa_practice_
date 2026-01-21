
import java.util.Scanner;

public class _49check_kth_bit {
    public static boolean check(int n , int k){
        
        // phle k bit ko right shift kar do : 
        int shift = n >> k;

        // ab 1 ke sath bitwise and operation perform kar do : 
        int result = shift & 1;

        // 1 & 1 = 1 && 1 & 0 = 0
        return result == 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number");
        int n = sc.nextInt();
        System.out.println("enter the value of k bit : ");
        int k = sc.nextInt();
        
        boolean ans =  check(n , k);
        System.out.println(ans);
    }
}
/*
Given two positive integer n and  k, check if the kth index bit of n is set or not.
 Note: A bit is called set if it is 1. 
 */