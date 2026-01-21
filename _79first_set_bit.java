
import java.util.Scanner;

public class _79first_set_bit {
    public static int first_set(int n){

        int count = 0;
        while(n != 0){
            count++;
            int rem = n & 1;
            if(rem == 1){
                return count;
            }
            n = n>>1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number : ");
        int n = sc.nextInt();

        int ans = first_set(n);
        System.out.println("first set bit position = " + ans);

    }
}
