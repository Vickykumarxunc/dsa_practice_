package DP.recursion;

public class _4print_1_to_n_using_backtrack {
    public static void print(int i , int n){
        if(i < 1){
            return;
        }
        print(i - 1 , n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        
    }
}
