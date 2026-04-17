package _1000;

public class _63sum_1to_n_divisor {
    public static int sum(int n){
        int sum = 0;
        for(int i = 1; i<=n; i++){
            sum += i * (n/i);
        }
        return sum;
    }
    public static void main(String[] args) {
        
    }
}
