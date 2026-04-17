package _1000;

public class _25reqeuncy_in_a_limited_range {
    public static int[] frequency(int arr[] , int n){
        int freq[] = new int[n];
        for(int i = 0; i<n; i++){
            freq[arr[i] - 1]++;
        }
        return freq;
    }
    public static void main(String[] args) {
        
    }
}
