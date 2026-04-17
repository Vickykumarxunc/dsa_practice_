package _1000;
import java.util.HashMap;

public class _66isomorphic_string {
    public static boolean ismorphic_string(String str1 , String str2 , int n , int m){
        if(n != m){
            return false;
        }
        HashMap<Character , Character> map1 = new HashMap<>();
        HashMap<Character , Character> map2 = new HashMap<>();

        for(int i = 0; i<n; i++){

            char sch = str1.charAt(i);
            char tch  = str2.charAt(i);
            
            // sch -> tch : 
            if(map1.containsKey(sch)){
                if(map1.get(sch) != tch){
                    return false;
                }
            }
            else{
                map1.put(sch , tch);
            }
            // tch -> sch : 
            if(map2.containsKey(tch)){
                if(map2.get(tch) != sch){
                    return false;
                }
            }
            else{
                map2.put(tch , sch);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
