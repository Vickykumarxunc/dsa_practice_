package _1000;

public class _261deletion_in_max_heap {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int deleteMax(int heap[] , int n){
        // if heap is empty : 
        if(n == 0){
            return -1;
        }
        // store the root element : 
        int max = heap[0];

        // repalce the root node with last node : 
        heap[0] = heap[n - 1];
        n--;

        int i = 0;
        // heapify top to bottom : 
        while(i < n){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if(left < n && heap[left] > heap[largest]){
                largest = left;
            }
            if(right < n && heap[right] > heap[largest]){
                largest = right;
            }
            if(largest != i){
                swap(heap , i , largest);
                i = largest;
            }
        }
        return max;
    }
    public static void print(int arr[] , int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int heap[] = {10 , 8 , 9 , 7};
        int n = heap.length;
        int removed = deleteMax(heap, n);
        n--;
        System.out.println("maximum element removed = " + removed);
        print(heap, n);

    }
}
