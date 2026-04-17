package _1000;

public class _193power_of_4 {
    public static boolean power_of4(int n){
        if(n <= 0){
            return false;
        }
        while(n % 4 == 0){
            n = n/4;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        
    }
}
