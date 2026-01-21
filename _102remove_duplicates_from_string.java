
import java.util.Scanner;
public class _102remove_duplicates_from_string {
    public static String remove(String s){

        // use the frequency array of size 26 : 
        int freq[] = new int[26];
        
        // use the stringbuilder for creating the ans : 
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] == 0){
                ans.append(ch);
            }
            freq[ch - 'a']++;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string : ");
        String s = sc.nextLine();

        String ans = remove(s);
        System.out.println(ans);
    }
}
