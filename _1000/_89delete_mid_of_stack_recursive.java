package _1000;
import java.util.Stack;

public class _89delete_mid_of_stack_recursive {
    public static void delete(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int n = st.size();
        int mid = n/2;
        delete_mid(st , 0 , mid);

    }
    public static void delete_mid(Stack<Integer> st , int k , int mid){

        if(k == mid){
            return;
        }
        int x = st.pop();
        delete_mid(st , k + 1 , mid);
        st.push(x);
    }
    public static void main(String[] args) {
        
    }
}
