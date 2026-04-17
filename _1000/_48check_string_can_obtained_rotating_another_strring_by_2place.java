package _1000;

public class _48check_string_can_obtained_rotating_another_strring_by_2place {
    public static boolean isrotation(String s1 , String s2 , int n , int m){
        if(n != m){
            return false;
        }
        boolean left = true;
        boolean right = true;
        for(int i = 0; i<n; i++){
            if(s2.charAt(i) != s1.charAt((i + 2) % n)){
                left = false;
            }
            if(s2.charAt(i) != s1.charAt((n + i - 2) % n)){
                right = false;
            }
            if(left == false || right == false){
                break;
            }
        } 
        return left || right;
    }
    public static void main(String[] args) {
        
    }
}
