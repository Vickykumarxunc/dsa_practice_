package _1000;
import java.util.ArrayList;

public class _260deletion_in_min_heap {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int deleteMin(int heap[] , int n){
        
        // if heap is empty : 
        if(n == 0){
            return -1;
        }
        // store the root : 
        int min = heap[0];

        // root ko last element se replace kar do : 
        heap[0] = heap[n - 1];
        n--;

        int i = 0;

        // heapify down : 
        while(i < n){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            // check left is smaller : 
            if(left < n && heap[left] < heap[smallest]){
                smallest = left;
            }
            // check right is smaller : 
            if(right < n && heap[right] < heap[smallest]){
                smallest = right;
            }
            if(smallest != i){
                swap(heap , i , smallest);

                // i ko neeche la aao : 
                i = smallest;
            }
            else{
                break;
            }
        }
        return min;
    }
    public static void print(int arr[] , int size){
        for(int i = 0; i<size; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int heap[] = {2 , 5 , 20 , 10};
        int size = heap.length;

        int removed = deleteMin(heap , size);
        size--;

        System.out.println("delete minimum = " + removed);
        print(heap , size);


    }
}
/// root ko last element se replace kar do
/// size-- decrease
/// heapify(top to bottom)

