package DP.recursion;

public class _5sum_of_first_n_number {
    public static void print(int i , int sum){
        if(i < 1){
            System.out.println(sum);
            return;
        }
        print(i - 1 , sum + i);
    }
    public static int sum(int n){
        if(n == 1){
            return n;
        }
        return n + sum(n - 1);
    }
    public static void main(String[] args) {
        int i = 10;
        int sum = 0;
        print(i , sum);
    }
}
