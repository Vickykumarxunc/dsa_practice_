package _1000;

public class _357find_nth_root_of_m {
    public static int find_nth_root_of_m(int n , int m){

        int low = 1;
        int high = m;

        while(low <= high){

            // calculate mid : 
            int mid = low + (high - low)/2;

            // calculate the nth root of mid : 
            long nth_root = 1;
            for(int i = 0; i<n; i++){
                nth_root *= mid;
                if(nth_root > m){
                    break;
                }
            }

            // compare with given number : 
            // agar mid ka nth root m ke barabar hai return mid : 
            if(nth_root == m){
                return mid;
            }
            // agar nth root m sa bada hai go left side : 
            else if(nth_root > m){
                high = mid - 1;
            }
            // agar nth root m se chota hai go right side : 
            else{
                low = mid + 1;
            }
        }
        // agar nth root nahi present hai return -1 : 
        return -1;
    }
    public static void main(String args[]){

    }
}
