package _1000;

public class _17power_of_2 {
    public static boolean power_of2(int n){
        return (n & (n - 1)) == 0;
    }
    public static boolean power(int n ){
        while(n  % 2 == 0){
            n = n/2;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        
    }
}
