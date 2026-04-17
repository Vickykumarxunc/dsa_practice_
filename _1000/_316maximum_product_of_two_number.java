package _1000;

public class _316maximum_product_of_two_number{
    public static int maximum_product(int arr[] , int n){

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){

            if(arr[i] >= max1){
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] >= max2){
                max2 = arr[i];
            }
            if(arr[i] <= min1){
                min2 = min1;
                min1 = arr[i];
            }
            else if(arr[i] <= min2){
                min2 = arr[i];
            }
        }
        return Math.max(min1 * min2 , max1 * max2);
    }
    public static void main(String[] args) {
        
    }
}
