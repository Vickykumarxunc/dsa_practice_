package _1000;
import java.util.Stack;

public class _312next_smaller_element_from_left {
    public static int[] next_smaller(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        ans[0] = -1;
        st.push(arr[0]);

        for(int i = 1; i<n; i++){
            // pop the larger element : 
            while(!st.isEmpty() && arr[i] <= st.peek()){
                st.pop();
            }
            // if not exist : 
            if(st.isEmpty()){
                ans[i] = -1;
            }
            // if exist : 
            else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
