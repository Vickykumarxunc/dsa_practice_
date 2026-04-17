package _1000;

import java.util.LinkedList;
import java.util.Queue;

// har ek step par batana hai ki first non repeating character kon sa hoga : 
public class _358first_non_repeating_character_in_a_stream {
    public static String first_non_repeating_character_in_a_stream(String str , int n){

        // hum ek queue use karege current string ka order maintain karne ke liye : 
        // aur ek frequency array maintain karege har ek character ki frequency count karne ke liye : 

        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        // traverse the string : 
        for(int i = 0; i<n; i++){

            // current character : 
            char ch = str.charAt(i);

            // phle uski frequency increase kar do : 
            freq[ch - 'a']++;

            // use queue me add karo do : 
            q.add(ch);

            // hame sirf har ek stream ka first non repeating charcter maintain karna hai : 
            // jo character queue to front par pada hai agar uski frequency ek se jyada hai to vo 
            // non repeating character nahi hai current stream ka to use remove karo : 
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.poll();
            }
            // agar queue empty hai to current stream ka first non repeating character exist nahi karta : 
            if(q.isEmpty()){
                ans.append('#');
            }
            else{
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        
    }
}
