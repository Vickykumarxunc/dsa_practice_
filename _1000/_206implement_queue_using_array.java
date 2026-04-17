package _1000;
class Queue{
    int arr[];
    int max_size;
    int front;
    int rear;
    int size;
    Queue(){
        max_size = 1000;
        arr = new int[max_size];
        front = -1;
        rear = -1;
        size = 0;
    }
    boolean isEmpty(){
        return front == -1;
    }
    boolean isFull(){
        return rear == max_size - 1;
    }
    void enqueue(int key){
        if(rear == max_size - 1){
            System.out.println("queue is overflow : ");
            return;
        }
        if(front == -1){
            front = 0;
        }
        rear++;
        arr[rear] = key;
        size++;
    }
    int dequeue(){
        if(front == -1){
            System.out.println("queue is underflow : ");
            return -1;
        }
        int pop_element = arr[front];
        if(front == rear){
            front = -1;
            rear = -1;
        }
        size--;
        return pop_element;
    }
    int peek(){
        if(front == -1){
            System.out.println("queue is empty : ");
            return -1;
        }
        return arr[front];
    }
    int size(){
        return size;
    }
}
public class _206implement_queue_using_array {
    public static void main(String[] args) {
        
    }
}
