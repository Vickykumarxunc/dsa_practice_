package _1000;

public class _264heapSort_ascending_order {
    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(int arr[] , int n , int i){
        while(i >= 0){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if(left < n && arr[left] > arr[largest]){
                largest = left;
            }
            if(right < n && arr[right] > arr[largest]){
                largest = right;
            }
            if(largest != i){
                swap(arr , i , largest);
                i = largest;
            }
            else{
                break;
            }
        }
    }
    // O(nlogn) in all cases unstable in place 
    public static void heapSort(int arr[] , int n){
        
        // first build the max heap : O(n)
        for(int i = n/2 - 1; i>= 0; i--){
            heapify(arr , n , i);
        }
        // extract element : O(logn)
        for(int i = n - 1; i>= 0; i--){

            // root ko last se swap karo : 
            // reduce the size : 
            // move max to end : 
            swap(arr , i , 0);

            // fix the remainging heap 
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
        print(arr , n);
    }
}
