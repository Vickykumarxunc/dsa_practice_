package _1000;

public class _42product_of_array_except_it_self {
    public static int[] product_array_except_itself(int arr[] , int n){
        int result[] = new int[n];
        result[n - 1] = arr[n - 1];
        for(int i = n - 2; i<= 0; i--){
            result[i] = arr[i] * result[i + 1];
        }
        int mul = 1;
        for(int i = 0; i<n - 1; i++){
            result[i] = result[i + 1] * mul;
            mul *= arr[i];
        }
        result[n - 1] = mul;
        return result;
    }
    public static void main(String[] args) {
        
    }
}
