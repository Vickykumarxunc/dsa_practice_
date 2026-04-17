package _1000;

public class _1missing_element_in_array {
    public static int missing_element(int arr[] , int n){
        int m = n + 1;
        int total_element = (m + (m + 1))/2;
        for(int i = 0; i<n; i++){
            total_element -= arr[i];
        }
        int missing_element = total_element;
        return missing_element;
    }
    public static void main(String[] args) {
        
    }
}
