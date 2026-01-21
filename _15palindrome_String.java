
import java.util.Scanner;

public class _15palindrome_String {
    public static boolean isPalindrome(String s1){
        int n = s1.length();

        // traverse the string at the half distance : 
        for(int i = 0; i<n/2; i++){
            
            // condition of the palindrome : 
            if(s1.charAt(i) != s1.charAt(n - i - 1)){
                return false;
            }
        }
        // if string is palindrome return true : 
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the String : ");
        String s1 = sc.nextLine();
        boolean ans = isPalindrome(s1);
        System.out.println("string is palindrome or not = " + ans);
        
    }
}
