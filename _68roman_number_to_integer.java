
import java.util.Scanner;

public class _68roman_number_to_integer {
    public static int number(char ch){
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        else if(ch == 'M') return 1000;
        return 0;
    }
    public static int convert(String s){
        int n = s.length();
        // traverse the string : 
        int ans = 0;
        for(int i = 0; i< s.length() - 1; i++){

            int curr = number(s.charAt(i));
            int next = number(s.charAt(i + 1));

            if(curr < next){
                ans -= curr;
            }
            else if(curr > next){
                ans += curr;
            }
        }
        // last value always add hogi : 
        int x = number(s.charAt(n - 1));
        ans += x;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string in the roman format : ");
        String s = sc.nextLine();

        int ans = convert(s);
        System.out.println(ans);


    }
}
