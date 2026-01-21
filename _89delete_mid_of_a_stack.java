import java.util.Stack;
public class _89delete_mid_of_a_stack {

    // iterative appraoch: : : : : : 
    public static void  delete(Stack<Integer> st){

        Stack<Integer> helper = new Stack<>();
        int mid = st.size()/2;

        for(int i = 0; i<mid; i++){
            helper.push(st.pop());
        }
        // pop the middle element from the stack : 
         st.pop();
        // now push the element : 
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
    }

    // recursive approach :  : : 
    public static void deleteMiddle(Stack<Integer> st , int k){

        // base condition 
        if(k == 1){
            st.pop();
            return;
        }
        int top = st.pop();
        deleteMiddle(st , k - 1);
        st.push(top);
    }
    public static void print(Stack<Integer> st){
        for(int element : st){
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        

        print(st);

        delete(st);

        print(st);

        int k = (st.size() + 1)/2;
        deleteMiddle(st, k);

        print(st);
    }
}
/*
Given a stack s, delete the middle element of the stack without using any additional data structure.

Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from the bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.
 */
