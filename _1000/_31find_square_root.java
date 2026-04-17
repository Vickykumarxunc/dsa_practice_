package _1000;

public class _31find_square_root {
    public static int find_square(int n){
        int low = 1;
        int high = n;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int square = mid + mid;
            if(square == n){
                return n;
            }
            else if(square < n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
