package DP.recursion;

public class _1print_name_n_time {
    public static void print(int i , int n){

        // base case : 
        if(i > n){
            return;
        }
        // body : 
        System.out.println("vicky");
        // recursion call : 
        print(i + 1 , n);
    }
    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        print(1 , n);
    }
}
