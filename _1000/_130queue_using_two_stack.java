package _1000;
import java.util.Stack;

class Queue{
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    void enqueue(int x){
        st1.push(x);
    }
    int dequeue(){
        if(st1.isEmpty() && st2.isEmpty()){
            return -1;
        }
        if(!st2.isEmpty()){
            return st2.pop();
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.pop();
    }
}
public class _130queue_using_two_stack {
    public static void main(String[] args) {
        
    }
}
