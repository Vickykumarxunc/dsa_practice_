package _1000;

public class _47insertionsort {
    public static void insertionSort(int arr[] , int n){
        for(int i = 1; i<n - 1; i++){
            int j = i; 
            while(j > 0 && arr[j] < arr[i - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            } 
        }
    }
    public static void main(String[] args) {
        
    }
}
