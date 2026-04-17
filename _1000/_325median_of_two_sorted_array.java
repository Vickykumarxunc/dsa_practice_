package _1000;
public class _325median_of_two_sorted_array {
    public static double findMedianSortedArrays(int arr1[] , int arr2[]){

        int n1 = arr1.length;
        int n2 = arr2.length;

        // step1 : ensure arr1 is always the smaller array : 
        if(n1 > n2){
            return findMedianSortedArrays(arr2 , arr1);
        }
        // we always apply the binary search on the smaller size array : 
        int low = 0;
        int high = n1;

        while(low <= high){

            // mid1 : arr1 me se kitne element symmetric line ke left side me lene hai: 
            int mid1 = (low + high)/2;

            // mid2 : automatically decide hoga taki total left side half element ho : 
            int mid2 = (n1 + n2 + 1)/2 - mid1;

            // left side ka last element : 
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];

            // right side ka first element : 
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : arr2[mid2];

            // check valid partition : 
            // matlab left side ke sab eleemnt <= right side ke sab element : 
            // cross checking : 
            if(l1 <= r2 && l2 <= r1){

                // agar total element even hai : 
                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1 , l2) + Math.min(r1 , r2))/2.0;
                }
                // agar total element odd hai : 
                else{
                    return Math.max(l1 , l2);
                }
            }
            // agar arr1 ka left part bada ho gaya :
            else if(l1 > r2){
                high = mid1 - 1; // left side kam karo : 
            }
            // warna arr2 ka left part chota karo : 
            else{
                low = mid1 + 1; // left side badao 
            }
        }
        return 0; // kabhi nahi aaye ga valid input me : 
    }
    public static void main(String[] args) {
        
    }
}