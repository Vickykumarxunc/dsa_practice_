package _1000;

import java.util.Queue;
import java.util.Stack;

public class _92reverse_the_queue_iterative {
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            st.push(q.poll());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }

    public static void main(String[] args) {

    }
}
