package _1000;

class Stack{
    int arr[];
    int size;
    int top1;
    int top2;
    Stack(){
        size = 100;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }
    void push1(int x){

        // stack is full : 
        if(top1 + 1 == top2){
            return;
        }
        arr[++top1] = x;
    }
    void push2(int x){

        // stack is full : 
        if(top1 + 1 == top2){
            return;
        }
        arr[--top2] = x;
    }
    int pop1(){

        // stack is empty : 
        if(top1 == -1){
            return -1;
        }
        return arr[top1--];
    }
    int pop2(){

        // stack is empty : 
        if(top2 == size){
            return -1;
        }
        return arr[top2++];
    }
}
public class _128two_stack_in_one_array {
    public static void main(String[] args) {
        
    }
}
