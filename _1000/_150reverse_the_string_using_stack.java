package _1000;
import java.util.Stack;

public class _150reverse_the_string_using_stack {
    public static String reverse(String str , int n){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<n; i++){
            st.push(str.charAt(i));
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return st.toString();
    }
    public static void main(String[] args) {
        
    }
}
