
import java.util.Scanner;

public class _94Number_of_1_bits {
    public static int setBits(int n){

        int count = 0;
        while(n != 0){
            count += n & 1;
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();

        int count = setBits(n);
        System.out.println("no of 1s = " + count);

    }
}
