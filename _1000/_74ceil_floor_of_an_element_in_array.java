package _1000;

import java.util.ArrayList;

public class _74ceil_floor_of_an_element_in_array {
    public static ArrayList<Integer> ceil_floor(int arr[] , int n , int target){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int ceil = -1;
        int floor = -1;
        for(int i = 0; i<n; i++){
            if(arr[i] < max  && arr[i] >= target){
                max = arr[i];
                ceil = arr[i];
            }
            if(arr[i] > min && arr[i] <= target){
                min = arr[i];
                floor = arr[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(floor);
        list.add(ceil);
        return list;
    }
    public static void main(String[] args) {
        
    }
}
