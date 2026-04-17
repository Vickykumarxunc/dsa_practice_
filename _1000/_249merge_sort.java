package _1000;

public class _249merge_sort {
    public static void merge(int arr[] , int l , int mid , int r){
        // create a two array to store the left and right subarray : 
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        // copy left
        for(int i = 0; i<n1; i++){
            left[i] = arr[i];
        }
        // copy right
        for(int i = 0; i<n2; i++){
            right[i] = arr[mid + i + 1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
    }
    public static void mergeSort(int arr[] , int left , int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(arr , left , mid);
        mergeSort(arr , mid + 1 , right);
        merge(arr , left , mid , right);
    }
    public static void main(String[] args) {
        
    }
}
