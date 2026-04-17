package _1000;

public class _326kth_element_of_two_sorted_array {
    public static int kth_element_of_two_sorted_array(int arr1[] , int arr2[] , int k){

        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1 > n2){
            return kth_element_of_two_sorted_array(arr2 , arr1 , k);
        }
        // we always apply the binary search on the smallest size array ;
        int low = Math.max(0 , k - n2); // minimum elements num1 se lena padega : 
        int high = Math.min(n1 , k); // maximum k hi le sakte hai

        while(low <= high){

            // arr1 se kitne element le rahe hai : 
            int mid1 = (low + high)/2;

            // remainging element num2 se lege : 
            int mid2 = (k - mid1);

            // left side ke element : 
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];

            // right side ke elements : 
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : arr2[mid2];

            //valid partition : 
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1 , l2);
            }
            // arr1 ka left part bada hai kam karo : 
            else if(l1 > n2){
                high = mid1 - 1;
            }
            // arr1 ka left part chota hai bada karo : 
            else{
                low = mid1 + 1;
            }
        }
        return -1; // in valid case : 
    }
    public static void main(String[] args) {
        
    }
}
