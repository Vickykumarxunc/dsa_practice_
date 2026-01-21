
import java.util.Scanner;

public class _146remove_consecutive_character_from_string {
    public static String remove(String str , int n){
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        for(int i = 1; i<n; i++){
            if(str.charAt(i) != ans.charAt(ans.length() - 1)){
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string : ");
        String str = sc.nextLine();

        String ans = remove(str, str.length());
        System.out.println(ans);
    }
}
                                                                    