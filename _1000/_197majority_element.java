package _1000;

public class _197majority_element {
    public static int majority_element(int arr[] , int n){
        int value = arr[0];
        int count = 1;
        for(int i = 1; i<n; i++){

            if(arr[i] == value){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                value = arr[i];
                count = 1;
            }
        }
        int freq = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == value){
                freq++;
            }
        }
        return freq >= n/2 ? value : -1;
    }
    public static void main(String[] args) {
        
    }
}
