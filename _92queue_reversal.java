
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _92queue_reversal{

    // iterative approach : 
    public static void reverse(Queue<Integer> q){

        // hum queue ko reverse karne ke liye stack ka use karege : 
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        // ab dobara se queue me element push kar do : 
        while(!st.isEmpty()){
            q.add(st.pop());
        }
    }
    public static void reverse2(Queue<Integer> q){

        // base condtion : 
        if(q.isEmpty()){
            return;
        }
        // front element nikalo :
        int front = q.remove();

        // reverse2 function call karo : 
        reverse2(q);

        // nikala hua element dobara se daal do queue me : 
        q.add(front);
    }
    public static void print(Queue<Integer> q){
        for(int element : q){
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(10);
        q.add(15);
        q.add(20);
        q.add(25);

        print(q);

        reverse(q);

        print(q);
    }
}
