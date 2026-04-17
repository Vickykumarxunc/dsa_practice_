package DP.recursion;

public class practice {
    // print name 5 times : 
    public static void printname(int n){
        if(n == 0){
            return;
        }
        System.out.println("vicky");
        printname(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
