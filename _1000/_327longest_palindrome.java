package _1000;
import java.util.HashMap;

public class _327longest_palindrome {
    public static int palindrome(String str){
        int n = str.length();

        // we use the hashMap to store the frequency of each character : 
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            char ch = str.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        // agar kisi character ki frequency odd hai to vo center me bhai aa sakti ahi ; 
        boolean odd = false;
        int length = 0;
        
        for(int key : map.keySet()){
            if(map.get(key) % 2 == 0){
                length += map.get(key);
            }
            else{
                odd = true;
                length += map.get(key) - 1;
            }
        }
        return odd == true ? length + 1 : length;
    }
    public static void main(String[] args) {
        
    }
}
