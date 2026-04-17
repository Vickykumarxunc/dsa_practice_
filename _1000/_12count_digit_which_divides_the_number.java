package _1000;

public class _12count_digit_which_divides_the_number {
    public static int count_digit(int n){
        int m = n;
        int count = 0;
        while(m != 0){
            int rem = m % 10;
            if(n % rem == 0){
                count++;
            }
            m = m/10;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
