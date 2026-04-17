package DP.recursion;

public class _6factorial {
    public static int fact(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n * fact(n - 1);
    }
    public static void fact(int i , int fact){
        if(i == 1 || i == 0){
            System.out.println(fact);
            return;
        }
        fact(i - 1 , fact * i);
    }
    public static void main(String[] args) {
        int n = 5;
        int fact = 1;
        fact(n , fact);
    }
}
