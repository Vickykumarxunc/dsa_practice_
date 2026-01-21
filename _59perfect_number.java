
import java.util.Scanner;
public class _59perfect_number {
    public static boolean check(int n){
        int sum = 1;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                sum += i;
            }
            int pair = n/ i;
            if(pair != i){
                sum += pair; // add paired division : 
            }
        }
        // condition of the perfect number :
        return sum == n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number : ");
        int n = sc.nextInt();
        boolean check = check(n);
        System.out.println(check);
    }
}
/*
Given a number n, check if the number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number.
 */
