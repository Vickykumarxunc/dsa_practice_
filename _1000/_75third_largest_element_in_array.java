package _1000;

public class _75third_largest_element_in_array {
    public static int third_largest(int arr[] ,int n){
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;
        for(int i = 0;  i<n; i++){
            if(arr[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] > max2 && arr[i] != max1){
                max3 = max2;
                max2 = arr[i];
            }
            else if(arr[i] > max3 && arr[i] > max2 && arr[i] > max1){
                max3 = arr[i];
            }
        }
        return max3;
    }
    
    public static void main(String[] args) {
        
    }
}
