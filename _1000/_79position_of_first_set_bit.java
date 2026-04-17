package _1000;

public class _79position_of_first_set_bit {
    public static int position_of_first_bit(int n){
        int count = 0;
        while(n != 0){
            count++;
            if((n & 1) == 1){
                return count;
            }
            n = n>>1;
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
