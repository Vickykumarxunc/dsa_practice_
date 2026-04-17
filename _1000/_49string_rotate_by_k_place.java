package _1000;

public class _49string_rotate_by_k_place {
    public static String rotate(String s , int n , int k){
        k = k % n;
        char ch[] = s.toCharArray();
        reverse(ch , 0 , k - 1);
        reverse(ch , k , n - 1);
        reverse(ch , 0 , n - 1);
        return new String(ch);
    }
    public static void reverse(char ch[] , int i , int j){
        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        
    }
}
