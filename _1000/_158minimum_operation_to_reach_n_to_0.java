package _1000;

public class _158minimum_operation_to_reach_n_to_0 {
    public static int minimum_operation(int n){
        int count = 0;
        while(n != 0){
            if(n % 2 == 0){
                n = n/2;
            }
            else{
                n = n - 1;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
