import java.util.ArrayList;
import java.util.Scanner;
public class _104factorial_less_than_or_equal_to_n {
    public static ArrayList<Long> factorialNumbers(long n){

        ArrayList<Long> list = new ArrayList<>();
        long fact = 1;
        for(int i = 1; i<=n; i++){
            fact *= i;
            if(fact <= n){
                list.add(fact);
            }else{
                break;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        long n = sc.nextLong();

        ArrayList<Long> ans = factorialNumbers(n);
        System.out.println(ans);
    }
}
/*
A number n is called a factorial number if it is the factorial of a positive integer. For example, the first few factorial numbers are 1, 2, 6, 24, 120,
Given a number n, the task is to return the list/vector of the factorial numbers smaller than or equal to n
 */
