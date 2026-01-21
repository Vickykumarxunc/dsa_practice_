class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
     }
class Stack{

    Node head; // stack ka top  
     
     // push the element into the stack : 
     void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
     }

     // pop the element from the stack  : 
     void pop(){
        if(head == null){
            System.out.println("stack is empty : ");
            return;
        }
        int pop_element = head.data;
        head = head.next;
        System.out.println("poped element = "  + pop_element);
     }
     
     // peek element from the stack : 
     int peek(){
        if(head == null){
            return -1;
        }
        return head.data;
     }

     // check stack is empty or not : 
     boolean isEmpty(){
        return head == null;
     }

     // size of the stack : 
     int size(){
        if(head == null){
            return 0;
        }
        Node temp = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
     }

     // print the stack : 
     void print(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class _72stack_using_linkedList {
    public static void main(String[] args) {
        
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println("size of the stack = " + st.size());
        System.out.println("top most element of the list = " + st.peek());


        st.print();

        st.pop();

        System.out.println("stack is empty or not = " + st.isEmpty());
        System.out.println("size of the stack = " + st.size());
        




    }
}
