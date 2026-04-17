package _1000;
import java.util.Stack;

public class _5balanced_parentthesis_or_not {
    public static boolean balanced_parentthesis(String str , int n){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else if((ch == ')' && st.peek() != '(') || (ch == '}' && st.peek() != '{') || (ch == ']' && st.peek() != '[')){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        
    }
}
