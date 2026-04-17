package _1000;

public class _40longest_common_prefix_in_string {
    public static String lcp(String arr[] , int n){
        String result = arr[0];
        for(int i = 1; i<n; i++){
            result = compare(result , arr[i]);
            if(result.equals("")){
                return "$";
            }
        }
        return result;
    }
    public static String compare(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        int i = 0;
        int j = 0;
        String result = "";
        while(i < n && j < m){
            if(str1.charAt(i) == str2.charAt(j)){
                result += str1.charAt(i);
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        
    }
}
