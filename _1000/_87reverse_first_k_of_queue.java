package _1000;
import java.util.Stack;
import java.util.Queue;

public class _87reverse_first_k_of_queue {
    public static Queue<Integer> reverse(Queue<Integer> q , int k){
        if(k <= 0 || k > q.size()){
            return q;
        }
        Stack<Integer> st = new Stack<>();
        int n = q.size();

        for(int i = 0; i<k; i++){
            st.push(q.remove());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        for(int i = 0; i<n-k; i++){
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        
    }
}
