package _1000;

import java.util.Stack;

public class _126valid_preorder {
    public static boolean valid_prerorder(int preorder[] , int n){
        Stack<Integer> st = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){

            // invalid 
            if(preorder[i] < min){
                return false;
            }
            // move right;
            while(!st.isEmpty() && preorder[i] > st.peek()){
                min = st.pop();
            }
            // move left 
            st.push(preorder[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
