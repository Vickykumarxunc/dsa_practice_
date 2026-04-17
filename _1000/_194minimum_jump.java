package _1000;

public class _194minimum_jump {
    public static int minimum_jump(int arr[] , int n){
        if(arr[0] == 0){
            return -1;
        }
        if(n <= 1){
            return 0;
        }
        int max_reach = arr[0];
        int steps = arr[0];
        int jump = 1;

        for(int i = 1; i<n; i++){

            // update the max reach 
            // har baar current state par khade hokar check karo mai kaha tak ja sakta hoon 
            max_reach = Math.max(max_reach , i + arr[i]);
            
            // consume one step of max_reach : 
            steps--;

            // agar step khatam ho jaye 
            // to ek nayi jump lo  : 
            if(steps == 0){
                jump++;

                // agar mai reach nahi kar sakta  :
                if(i >= max_reach){
                    return -1;
                }
                // update the step : 
                steps = max_reach - i;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        
    }
}
