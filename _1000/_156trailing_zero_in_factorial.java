package _1000;

public class _156trailing_zero_in_factorial {
    public static int trailing_zero(int n){
        int count = 0;
        while(n != 0){
             n = n/5;
             count += n;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
