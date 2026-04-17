package DP.recursion;

public class _2print_1_to_n {
    public static void print(int i , int n){
        if(i > n){
            return;
        }
        System.out.println(i);
        print(i + 1 , n);
    }
    public static void main(String[] args) {
        int n = 10;
        int i = 1;
        print(i , n);
    }
}
