import java.util.Scanner;

public class _150minimum_operation_to_reach_n_to_0 {
    public static int min_operation(int n){

        int count = 0;
        while(n != 0){

            if(n % 2 == 0){
                n = n/2;
            }
            else{
                n = n - 1;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number n : ");
        int n = sc.nextInt();
        int ans = min_operation(n);
        System.out.println(ans);
    }
}
/*
Given a number n. Find the minimum number of operations required to reach n starting from 0. You have two operations available:

Double the number
Add one to the number
 */
