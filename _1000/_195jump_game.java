package _1000;

public class _195jump_game {
    public static boolean jump_game(int arr[] , int n){
        if(arr[0] == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        int max_reach = arr[0];
        for(int i = 1; i<n; i++){
            
            if(i >= max_reach){
                return false;
            }
            max_reach = Math.max(max_reach , i + arr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
