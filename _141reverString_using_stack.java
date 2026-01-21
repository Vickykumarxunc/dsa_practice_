import java.util.Scanner;
import java.util.Stack;
public class _141reverString_using_stack {
    public static String reverse(String str , int n){

        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            st.push(str.charAt(i));
        }
        str = "";
        while(!st.isEmpty()){
            str += st.pop();
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string : ");
        String str = sc.nextLine();

        String ans = reverse(str, str.length());
        System.out.println(ans);
    }
}
