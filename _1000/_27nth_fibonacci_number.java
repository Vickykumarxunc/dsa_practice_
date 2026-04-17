package _1000;

public class _27nth_fibonacci_number {
    public static int nth_number(int n){
        if(n == 1 || n == 0){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {
        
    }
}
