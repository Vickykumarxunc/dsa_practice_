package _1000;

import java.util.Stack;

public class _127valid_post_order {
    public static boolean valid_postorder(int postorder[] , int n){
        Stack<Integer> st = new Stack<>();
        int max = Integer.MAX_VALUE;
        
        for(int i = n - 1; i>= 0; i--){
            if(postorder[i] > max){
                return false;
            }
            while(!st.isEmpty() && postorder[i] < st.peek()){
                max = st.pop();
            }
            st.push(postorder[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
