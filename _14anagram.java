import java.util.HashMap;
import java.util.Scanner;

public class _14anagram {
    public static boolean isAnagram(String s1 , String s2){

        // create a HashMap : or frequency array : 
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch , map.getOrDefault(ch, 0) + 1);
        }
        // now traverse the second string : 
        for(int i = 0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(map.get(ch) == 0 || !map.containsKey(ch)){
                return false;
            }
            map.put(ch , map.get(ch) - 1);
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first string : ");
        String s1 = sc.nextLine();
        System.out.println("enter the second string : ");
        String s2 = sc.nextLine();

        boolean ans = isAnagram(s1, s2);
        System.out.println("string is anagram or not = " + ans);
        
    }
}
