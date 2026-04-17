package _1000;
import java.util.Stack;

public class _310next_greater_element_to_left {
    public static int[] next_greater(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        
        // first element ka next greater from left nahi hoga : 
        ans[0] = -1;
        st.push(arr[0]);

        // traverse array from forward direction : 
        for(int i = 1; i<n; i++){

            // jab tak current element se bada element nahi mil jata tab tak pop karo : 
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            // agar next greater element present nahi hai : 
            if(st.isEmpty()){
                ans[i] = -1;
            }
            // agar next greater element present hai : 
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
