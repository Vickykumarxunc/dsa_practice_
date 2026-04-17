package _1000;

public class _104remove_duplicate_from_string {
    public static String remove(String str , int n){
        int freq[] = new int[255];
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<n; i++){
            if(freq[str.charAt(i)] == 0){
                ans.append(str.charAt(i));
            }
            freq[str.charAt(i)]++;
        }
        return new String(ans);
    }
    public static void main(String[] args) {
        
    }
}
