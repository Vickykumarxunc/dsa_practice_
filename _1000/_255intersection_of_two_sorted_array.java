package _1000;
import java.util.ArrayList;
public class _255intersection_of_two_sorted_array{
    public static ArrayList<Integer> common(int arr1[] , int arr2[] , int n , int m){
        int i = 0; 
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < n && j < m){
            if(arr1[i] == arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return list;
    }
    public static void main(String args[]){

    }
}
