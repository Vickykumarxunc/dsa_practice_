package _1000;
import java.util.Stack;

public class _88delete_mid_of_the_stack {
    public static void delete_mid(Stack<Integer> st){
        int n = st.size();
        Stack<Integer> helper = new Stack<>();
        for(int i = 0; i<n/2; i++){
            helper.push(st.pop());
        }
        st.pop();
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
    }
    public static void main(String[] args) {
        
    }
}
