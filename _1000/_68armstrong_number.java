package _1000;

public class _68armstrong_number {
    public static boolean armstrong(int n){
        int m = n;
        int cube_sum = 0;
        while(n != 0){
            int x = n % m;
            cube_sum += x * x * x;
        }
        return cube_sum == n;
    }
    public static void main(String[] args) {
        
    }
}
