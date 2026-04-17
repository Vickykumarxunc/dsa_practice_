package _1000;

public class _94no_of_1_bit_in_numbe {
    public static int count1(int n){
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n = n/2;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
