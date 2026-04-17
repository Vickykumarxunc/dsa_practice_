package _1000;

public class _129largest_number_possible {
    public static String largest_number(int n , int sum){
        if(sum > n * 9){
            return "-1";
        }
        if(sum == 0){
            if(n == 1){
                return "0";
            }
            return "-1";
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<n; i++){
            if(sum >= 9){
                s.append(9);
                sum -= 9;
            }
            else{
                s.append(sum);
                sum = 0;
            }
        }
        return new String(s);
        
    }
    public static void main(String[] args) {
        
    }
}
