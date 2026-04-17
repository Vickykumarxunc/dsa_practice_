package _1000;
import java.util.ArrayList;
public class _258insert_in_min_heap {
    
    // using the array List ; 
    public static void insert(ArrayList<Integer> heap , int val){

        // first add the value in the last : 
        heap.add(val);

        // now rearrange it into min heap 
        int i = heap.size() - 1;
        while(i > 0){
            int parent = (i - 1)/2;
            if(heap.get(parent) > heap.get(i)){
                
                // parent and current value : 
                int temp = heap.get(parent);
                heap.set(parent , heap.get(i));
                heap.set(i , temp);

                // i ko parent par le jao : 
                i = parent;
            }
            else{
                break;
            }
        }
    }
    // using the array : 
    public static void insert(int arr[] , int size , int val){
        // insert at last 
        arr[size] = val;
        int i = size;
        
        // heapify : 
        while(i > 0){
            int parent = (i - 1)/2;
            if(arr[parent] > arr[i]){
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;
                i = parent;
            }
            else{
                break;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<>();
        insert(heap , 10);
        insert(heap , 5);
        insert(heap , 20);
        insert(heap , 2);
        System.out.println(heap);

        
    }
}
