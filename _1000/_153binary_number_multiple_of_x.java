package _1000;

public class _153binary_number_multiple_of_x {
    public static boolean check(String number , int x){
        int mod = 0;
        for(int i = 0; i<number.length(); i++){
            mod = (mod * 2 + (number.charAt(i) - '0')) % x;
        }
        return mod == 0;
    }
    public static void main(String[] args) {
        
    }
}
