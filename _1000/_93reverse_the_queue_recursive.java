package _1000;
import java.util.Queue;

public class _93reverse_the_queue_recursive {
    public static void reverse(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int front = q.remove();
        reverse(q);
        q.add(front);
    }
    
    public static void main(String[] args) {
        
    }
}
