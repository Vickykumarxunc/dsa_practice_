package _1000;
import java.util.Stack;

public class _311next_smaller_element_from_right {
    public static int[] next_smaller(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        ans[n - 1] = -1;
        st.push(arr[n - 1]);

        for(int i = n - 2; i>= 0; i--){

            // pop the larger element : 
            while(!st.isEmpty() && arr[i] <= st.peek()){
                st.pop();
            }
            // agar next smaller element present nahi karta : 
            if(st.isEmpty()){
                ans[i] = -1;
            }
            // agar exist karta hai : 
            else{
                ans[i] = st.peek();
            }
            // always push the current element : 
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
