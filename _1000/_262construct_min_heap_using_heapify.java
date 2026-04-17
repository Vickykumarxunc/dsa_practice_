package _1000;

public class _262construct_min_heap_using_heapify {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(int arr[] , int n , int i){
        while(i > 0){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;
            if(left < n && arr[left] < arr[smallest]){
                smallest = left;
            }
            if(right < n && arr[right] < arr[smallest]){
                smallest = right;
            }
            if(smallest != i){
                swap(arr , i , smallest);
                i = smallest;
            }
        }
    }
    public static void buildMinHeap(int arr[] , int n){
        // start from the last non leaf Node ;
        for(int i = n/2 - 1; i>= 0; i++){
            heapify(arr , n , i);
        }
    }
    public static void print(int arr[] , int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {10 , 5 , 20 , 2 , 4};
        int n = arr.length;
        buildMinHeap(arr, n);
        print(arr, n);
    }
}
