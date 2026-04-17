package _1000;
import java.util.ArrayList;

public class _86move_all_negative_element_at_end {
    public static void move(int arr[] , int n){
        ArrayList<Integer> negative = new ArrayList<>();
        int j = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                arr[j] = arr[i];
                j++;
            }
            else{
                negative.add(arr[i]);
            }
        }
        int k = 0;
        while(j < n){
            arr[j++] = negative.get(k++);
        }
    }
    public static void main(String[] args) {
        
    }
}
