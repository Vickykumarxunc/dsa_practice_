package _1000;

public class _265heapsort_for_descending_order {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // min heap : 
    public static void heapify(int arr[] , int n , int i){
        while(i < n){
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
            else{
                break;
            }
        }
    }
    public static void heapSort(int arr[] , int n){
        // build min heap : 
        for(int i = n/2 - 1; i>= 0; i--){
            heapify(arr , n , i);
        }
        // extract element 
        // root node last node se swap karo : 
        // reduce the size :
        // heapify and repeat 
        for(int i = n - 1; i>= 0; i--){
            swap(arr , i , 0);
            heapify(arr , i , 0);
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
        heapSort(arr, n);
        print(arr, n);
    }
}
