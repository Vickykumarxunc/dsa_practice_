package _1000;

public class _20check_prime_number {
    public static boolean check_prime(int n){
        if(n == 1 || n == 0){
            return false;
        }
        for(int i = 2; i * i<=n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
