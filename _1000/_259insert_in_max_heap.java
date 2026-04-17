package _1000;
import java.util.ArrayList;

public class _259insert_in_max_heap {
    public static void insert(ArrayList<Integer> heap , int val){

        // add in last : 
        heap.add(val);
        int i = heap.size() - 1;

        // heapify : 
        while(i > 0){
            int parent = (i - 1)/2;
            if(heap.get(parent) < heap.get(i)){
                int temp = heap.get(parent);
                heap.set(parent , heap.get(i));
                heap.set(i , temp);
                i = parent;
            }
            else{
                break;
            }
        }
    }
    public static void insert(int arr[] , int size , int val){

        // add last : 
        arr[size] = val;
        int i = size;

        // heapify :
        while(i > 0){
            int parent = (i - 1)/2;
            if(arr[parent] < arr[i]){
                int temp = arr[parent];
                arr[parent] = arr[i];
                arr[i] = temp;
                i = parent;
            }
            else{
                break;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> heap1 = new ArrayList<>();
        insert(heap1 , 1);
        insert(heap1 , 2);
        insert(heap1 , 3);

        int arr[] = new int[100];
        int size = 0;
        insert(arr , size++ , 5);
        insert(arr , size++ , 4);
    }
}
