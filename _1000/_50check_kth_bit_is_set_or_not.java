package _1000;

public class _50check_kth_bit_is_set_or_not {
    public static boolean check(int n , int k){
        int right_shift = n >> k;
        return (right_shift & 1) == 1;
    }
    public static void main(String[] args) {
        
    }
}
