package _1000;

public class _148length_of_the_last_word{
    public static int length_of_last_word(String str , int n){
        int count = 0;
        int i = n - 1;

        // remove the space from the last : 
        while(i >= 0 && str.charAt(i) == ' '){
            i--;
        }
        // count the length of the last character from the last : 
        while(i >= 0 && str.charAt(i) != ' '){
            count++;
            i--;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
