package _1000;

public class _136segregate_01 {
    public static void segregate(int arr[] , int n){
         int j = 0;
         for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                arr[j++] = arr[i]; 
            }
         }
         while(j < n){
            arr[j] = 1;
            j++;
        }
    }
    public static void segregate01(int arr[] , int n){
        int low = 0;
        int high = n - 1;
        
        while(low < high){
            if(arr[low] == 1 && arr[high] == 0){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
            if(arr[low] == 0){
                low++;
            }
            if(arr[high] == 1){
                high--;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
