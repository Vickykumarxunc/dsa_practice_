package _1000;

public class _60perfect_number {
    public static boolean perfect_number(int n){
        int sum = 1;
        for(int i = 2; i*i<=n; i++){
            if(n % i == 0){
                sum += i;
            }
            int pair = n/i;
            if(pair != i){
                sum += pair;
            }
        }
        return sum == n;
    }
    public static void main(String[] args) {
        
    }
}
