
import java.util.Scanner;

public class _48String_rotate_by_two_place {
    public static boolean isRotate(String s1 , String s2){

        int n = s1.length();

        // base condition : 
        // agar dono string ki length same nahi hai return false 
        // agar length 2 se kam hai return false : 
        if(n != s2.length() || n < 2){
            return false;
        }

        // anticlock wise rotation : 
        StringBuilder anti = new StringBuilder();
        for(int i = 2; i<n; i++){
             anti.append(s1.charAt(i));
        }
        anti.append(s1.charAt(0));
        anti.append(s1.charAt(1));

        // clock wise rotation : 
        StringBuilder clock = new StringBuilder();
        clock.append(s1.charAt(n - 2));
        clock.append(s1.charAt(n - 1));

        for(int i = 0; i<n - 2; i++){
             clock.append(s1.charAt(i));
        }
        return s2.equals(clock.toString()) || s2.equals(anti.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first String : ");
        String s1 = sc.nextLine();
        System.out.println("enter the second string : ");
        String s2 = sc.nextLine();

        boolean ans = isRotate(s1, s2);
        System.out.println(ans);
        
    }
}
