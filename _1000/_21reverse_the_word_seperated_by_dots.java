package _1000;

public class _21reverse_the_word_seperated_by_dots {
    public static String reverse(String str , int n){
        char ch[] = str.toCharArray();
        reverse(ch , 0 , n - 1);
        int start = 0;
        for(int i = 0; i<n; i++){
            if(ch[i] == '.'){
                reverse(ch , start , i - 1);
                start = i + 1;
            }
        }
        reverse(ch , start , n - 1);
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
