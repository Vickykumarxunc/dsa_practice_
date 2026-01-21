class stack{
     int arr[];
     int top1;
     int top2;
     int size;
     stack(){
        size = 100;
        arr = new int[size];
        top1 = -1;
        top2 = size;
     }
     public void push1(int x){

        // over flow : 
        if(top1 + 1 == top2){
            System.out.println("stack is full : ");
            return;
        }
        top1++;
        arr[top1] = x;
     }
     public void push2(int x){

        // over flow :
        if(top1 + 1 == top2){
            System.out.println("stack is over flow : ");
            return;
        }
        top2--;
        arr[top2] = x;
     }
     public int pop1(){

        //under flow : 
        if(top1 == -1){
            System.out.println("under flow : ");
            return -1;
        }
        int pop_element = arr[top1];
        top1--;
        return pop_element;
     }
     public int pop2(){

        // under flow : 
        if(top2 == size){
            System.out.println("under flow : ");
            return -1;
        }
        int pop_element = arr[top2];
        top2++;
        return pop_element;
     } 

    private static class st1 {

        public st1() {
        }
    }
}
public class _121two_stack_in_one_array {
    public static void main(String[] args) {
        
        stack st = new stack();
        st.push1(2);
        st.push1(3);
        st.push2(4);

        System.out.println(st.pop1());
        System.out.println(st.pop2());
        System.out.println(st.pop2());

    }
}
