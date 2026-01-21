
import java.util.Scanner;

public class _126most_frequent_charaacter {
    public static char getMaxOccuringChar(String s , int n){

        // create a frequency array of 26 : 
        int freq[] = new int[26];
        int max = Integer.MIN_VALUE;
        int index = -1;

        // count the frequency of each charcter : 
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for(int i = 0; i<26; i++){
            if(freq[i] > max){
                max = freq[i];
                index = i;
            }
        }
        // return the maximum occuring character : 
        char ans = (char)(index + 'a');
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the any string : ");
        String s = sc.nextLine();

        char ans = getMaxOccuringChar(s, s.length());
        System.out.println("maximum occuring character in lexicographical order  = " + ans);
    }
}
/*
?Given a string s of lowercase alphabets. The task is to find the maximum occurring character in the string s. If more than one character occurs the maximum number of times then print the lexicographically smaller character.
 */