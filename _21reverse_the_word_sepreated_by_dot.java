
import java.util.Scanner;

public class _21reverse_the_word_sepreated_by_dot {

    public static void reverse(char arr[] , int i , int j){

        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static String reverseWord(String str){
        int n = str.length();

        // string ko maine character array me convert kar liya : 
        char ch[] = str.toCharArray();

        // phle puri string ko reverse kar do : 
        reverse(ch , 0 , n - 1);

        // ap individual word ko reverse karo : 
        int start = 0;
        for(int i = 0; i<n; i++){

            // dot se phle tak reverse kar do : 
            if(ch[i] == '.'){

                reverse(ch, start, i - 1);
                 // fir start point ko update kar do : 
                start = i + 1;
            }
        }
        // last me last word ko reverse kar do : 
        reverse(ch , start , n - 1);

        // return the string : 
        return new String(ch);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string seperated by dot : ");
        String s = sc.nextLine();
    
        String ans = reverseWord(s);
        System.out.println(ans);
    }
}

/*
Input: s = "i.like.this.program.very.much"
Output: "much.very.program.this.like.i"
Explanation: The words in the input string are reversed while maintaining the dots as separators, resulting in "much.very.program.this.like.i".
 */
