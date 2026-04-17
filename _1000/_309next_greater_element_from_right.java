package _1000;
import java.util.Stack;

public class _309next_greater_element_from_right {
    public static int[] next_greater(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        
        // last element ka next greater nahi hoga to use hum -1 kar dege : 
        ans[n - 1] = -1;
        st.push(arr[n - 1]);

        // traverse from the right side : 
        for(int i = n - 2; i >= 0; i--){

            // element ko hum stack me se tab tak pop karege jab tak mujhe current element 
            // se greater element na mil jaye : 
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            // agar next greater element present nahi hai current element ka : 
            if(st.isEmpty()){
                ans[i] = -1;
            }
            // if next greater element present : 
            else{
                ans[i] = st.peek();
            }
            // always push the current element in the stack: 
            st.push(arr[i]);
        }
        return ans;

    }
    public static void main(String[] args) {
        
    }
}
