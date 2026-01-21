
import java.util.Scanner;

public class _37non_repeating_character {
    public static char find(String str){

        // create a frequency array of size 26 : 
        int freq[] = new int[26];   
        
        // now fill the frequency array : 
        for(int i = 0; i<str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }
        for(int i = 0; i<str.length(); i++){
            if(freq[str.charAt(i) - 'a'] == 1){
                return str.charAt(i);
            }
        }
        // agar non repeating character present nahi hai 
        return '$';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string : ");
        String str = sc.nextLine();

        char ch = find(str);
        System.out.println("non repeating character = " + ch);
    }
}
/*
Given a string s consisting of lowercase English Letters. return the first non-repeating character in s. If there is no non-repeating character, return '$'
 */