
import java.util.Scanner;

public class _17power_of_2 {
    public static boolean isPower2(int n){
        int ans = n & (n - 1);
        return ans == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any number : ");
        int n = sc.nextInt();

        boolean ans = isPower2(n);
        System.out.println(ans);
    }
}
