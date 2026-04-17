package _1000;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class Stack{
    Node head;
    int size = 0;

    boolean isEmpty(){
        return size == 0;
    }
    void push(int key){
        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
        size++;
    }
    int pop(){
        if(size == 0){
            System.out.println("stack is empty : ");
            return -1;
        }
        System.out.println(head.data);
        int pop_data = head.data;
        head = head.next;
        size--;
        return pop_data;
    }
    int size(){
        return size;
    }
    int peek(){
        if(size == 0){
            return -1;
        }
        return head.data;
    }
}
public class _72stack_using_linkedList {
    public static void main(String[] args) {
        Stack st = new Stack();
        
        st.push(10);
        st.push(30);
        

    }
}
