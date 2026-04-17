package _1000;
import java.util.ArrayList;

public class _308union_of_two_sorted_array {
    public static ArrayList<Integer> union(int arr1[] , int arr2[] , int n , int m){
         ArrayList<Integer> list = new ArrayList<>();
         int i = 0;
         int j = 0;

         while(i < n && j < m){

            int value;

            if(arr1[i] == arr2[j]){
                value = arr1[i];
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                value = arr1[i];
                i++;
            }
            else{
                value = arr2[j];
                j++;
            }
            //avoid duplicate : 
            if(list.isEmpty() || list.get(list.size() - 1) != value){
                list.add(value);
            }
         }
         // remaining element of array 1 : 
         while(i < n){
            if(list.isEmpty() || list.get(list.size() - 1) != arr1[i]){
                list.add(arr1[i]);
            }
            i++;
         }
         // remaining element of array 2 : 
         while(j < m){
            if(list.isEmpty() || list.get(list.size() - 1) != arr2[j]){
                list.add(arr2[j]);
            }
            j++;
         }
         return list;
    }
    public static void main(String[] args) {
        
    }
}
