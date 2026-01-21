
import java.util.Scanner;

public class _144is_binary_number_multiple_ofx {
    public static boolean isdivisible(String str , int n , int x){

        // common rule for any base and any number x : 
        // mode = ( mode * base + current bit ) % x 

        // mode property : 
        // (a * b + c) % x = ( (a % x) * (b % x) + c % x ) % x

        int mod = 0;
        for(int i = 0; i<n; i++){
            mod = (mod * 2 + (str.charAt(i) - '0')) % x;
        }
        // agar last me mod zero hai to number divisible hai varna nahi hai : 
        return mod == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the binary String : ");
        String str = sc.nextLine();
        System.out.println("enter the value of x : ");
        int x = sc.nextInt();

        boolean ans = isdivisible(str, str.length(), x);
        System.out.println(ans);
    }
}
