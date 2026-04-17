package _1000;

public class _314maximum_product_subarray {
    // time = O(n)
    // space = O(1)
    public static int maximum_product_subarray(int arr[] , int n){

        // hame har step par teen cheeje handle karni hai ; 
        // minimum kyo handle karna hai tak ye aage jake maximum bhi ban sakta hai : 
        int max = arr[0]; // current maximum 
        int min = arr[0]; // current minimum 
        int ans = arr[0]; // final ans 

        for(int i = 1; i<n; i++){

            // agar current element negative hai to maximum and minimum ko swap kar do : 
            if(arr[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }

            // now update the minimum and maximum : 
            max = Math.max(arr[i] , arr[i] * max);
            min = Math.min(arr[i] , arr[i] * min);
            
            // update the answer : 
            ans = Math.max(max , ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
