package _1000;

public class _192power_of_3 {
    public static boolean power_of_3(int n){
        if(n <= 0){
            return false;
        }
        while(n % 3 == 0){
            n = n/3;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        
    }
}
