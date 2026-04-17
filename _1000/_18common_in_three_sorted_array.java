package _1000;

import java.util.ArrayList;

public class _18common_in_three_sorted_array {
    public static ArrayList<Integer> common(int arr1[] , int arr2[] , int arr3[] , int n1 , int n2 , int n3){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0; 
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2 && k < n3){
            if(arr1[i] == arr2[j] && arr1[i] == arr3[k]){
                if(!list.contains(arr1[i])){
                    list.add(arr1[i]);
                }
                i++;
                j++;
                k++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr3[k]){
                j++;
            }
            else{
                k++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
