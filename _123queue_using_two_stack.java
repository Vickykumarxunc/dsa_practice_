import java.util.Stack;
class queue{

   static Stack<Integer> st1 = new Stack<>();
   static Stack<Integer> st2 = new Stack<>();
    void push(int x){

        // directly push into the st1 : 
        st1.push(x);
    }
    int pop(){

        // agar dono stack khali hai return -1 : 
        if(st1.isEmpty() && st2.isEmpty()){
            return -1;
        }
        // agar stack2 empty hai par stack 1 empty nahi hai 
        // to stack 1 me saare element stack me push kar do : 
        if(st2.isEmpty() && !st1.isEmpty()){

            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        // ap jo stack 2 ke top par hai vo queue ka first element hai: 
        return st2.pop();
    }
}
public class _123queue_using_two_stack {
    
    public static void main(String[] args) {
        
        queue q = new queue();
        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.pop());

        q.push(4);
        q.push(5);

        System.out.println(q.pop());

        q.push(6);

        System.out.println(q.pop());

        
    }
}
