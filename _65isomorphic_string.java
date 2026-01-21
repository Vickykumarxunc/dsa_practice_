
import java.util.HashMap;
import java.util.Scanner;

public class _65isomorphic_string {

    // using the 1 hashMap : 
    public static boolean isomorphic(String s , String t){

        // base condition : 
        // agar dono string ki length different hai to vo isomorphic nahi hai : 
        if(s.length() != t.length()){
            return false;
        }
        // create a hashMap for the one to one correspondence : 
        HashMap<Character , Character> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if(map.containsKey(sch)){
                if(map.get(sch) != tch){
                    return false;
                }
            }
            else if(map.containsValue(tch)){
                return false;
            }
            else{
                map.put(sch , tch);
            }
        }
        return true;
    }
    // using the two hashMap : 
    public static boolean check(String s , String t){
        
        if(s.length() != t.length())return false;

        HashMap<Character , Character> map1 = new HashMap<>();
        HashMap<Character , Character> map2 = new HashMap<>();

        for(int i = 0; i<s.length(); i++){

            char sch = s.charAt(i);
            char tch = t.charAt(i);

            // s - > t 
            if(map1.containsKey(sch) && map1.get(sch) != tch){
                return false;
            }
            // t - > s
            if(map2.containsKey(tch) && map2.get(tch) != sch){
                return false;
            }
            map1.put(sch , tch);
            map2.put(tch , sch);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first string : ");
        String s = sc.nextLine();
        System.out.println("enter the second string : ");
        String t = sc.nextLine();

        boolean ans = check(s, t);
        System.out.println("our string is isomorphic or not = " + ans);

    }

}