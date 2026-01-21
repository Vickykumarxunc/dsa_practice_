import java.util.*;
import java.util.Stack;
public class _88reverse_first_k_of_queue {
    public static Queue<Integer> reverse(Queue<Integer> q , int n , int k){

        // create a stack jo queue ke first k element store karege : 
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<k; i++){
            st.push(q.remove());
        }
        // ab first k element ko stack me se pop karke queue ke ander push kar do : 
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        // ab queue ke (n - k) bache hue element ko unki correction position par pahuchana : 
        for(int i = 0; i<n-k; i++){
            q.add(q.remove());
        }
        return q;
    }
    // print the queue : 
    public static void print(Queue<Integer>q){
        for(int x : q){
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        print(q);
        q = reverse(q, q.size(), 3);
        print(q);
    }
}
