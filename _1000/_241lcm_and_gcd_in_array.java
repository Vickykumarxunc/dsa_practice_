package _1000;
public class _241lcm_and_gcd_in_array{
    public static int gcd(int x , int y){
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
    public static int lcm(int arr[] , int n){
        int ans = arr[0];
        for(int i = 1; i<n; i++){
            if(arr[i] == 0){
                return 0;
            }
            int gcd = gcd(ans , arr[i]);
            ans = (ans/gcd)*arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}