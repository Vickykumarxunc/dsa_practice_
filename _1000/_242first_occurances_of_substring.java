package _1000;

public class _242first_occurances_of_substring {
    public static int first_occurance(String txt , String pat){
        int n = txt.length();
        int m = pat.length();
        for(int i = 0; i<n; i++){
           int j = 0;
           while(j < m && txt.charAt(i + j) == pat.charAt(j)){
            j++;
           }
           if(j == m){
            return i;
           }
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
