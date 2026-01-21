import java.util.Scanner;
import java.util.Stack;
public class _5parenthesis_checker {
    public static boolean isBalanced(String s){

        // create a stack 
        Stack<Character> st = new Stack<>();
        // traverse the string : 
        for(int i = 0; i<s.length(); i++){

            // opening bracket always push in the stack : 
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                // agar suru me hi closing bracket ho : 
                if(st.isEmpty()){
                    return false;
                }
                // agar bracket same type ke na ho : 
                else if((ch == '(' && st.peek() != ')') || (ch == '{' && st.peek() != '}') || (ch == '[') && st.peek() != ']'){
                    return false;
                }
                // agar bracket same type ke hai to stack me se pop kar do : 
                else{
                    st.pop();
                }
            }
             
        }
        // agar last me stack empty hai to return true else return false : 
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the parenthesis string : ");
        String str = sc.nextLine();

        boolean ans = isBalanced(str);
        System.out.println("is balanced or not = " + ans);

    }
}
