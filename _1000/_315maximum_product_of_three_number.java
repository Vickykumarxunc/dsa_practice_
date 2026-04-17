package _1000;

public class _315maximum_product_of_three_number{
    public static int maximum_product(int arr[] , int n){

        // maintain the two minimum number : 
        // agar large negative number hue to unka product maximum ho sakta hai 
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;

        // maintain the three large number : 
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;

        for(int i = 0; i<n; i++){

            // maximum check : 
            if(arr[i] >= max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] >= max2){
                max3 = max2;
                max2 = arr[i];
            }
            else if(arr[i] >= max3){
                max3 = arr[i];
            }
            // minimum check : 
            if(arr[i] <= min1){
                min2 = min1;
                min1 = arr[i];
            }
            else if(arr[i] <= min2){
                min2 = arr[i];
            }
        }
        return Math.max(min1 * min2 * max1 , max1 * max2 * max3);
    }
    public static void main(String args[]){

    }
    
}
