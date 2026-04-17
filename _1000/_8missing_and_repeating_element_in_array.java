package _1000;

import java.util.ArrayList;

public class _8missing_and_repeating_element_in_array {
    public static ArrayList<Integer> find_missing_repeating(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int missing_element = -1;
        int repeating_element = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                repeating_element = Math.abs(arr[i]);
            } else {
                arr[index] = -1 * arr[index];
            }
        }
        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                missing_element = i + 1;
                break;
            }
        }
        list.add(missing_element);
        list.add(repeating_element);
        return list;
    }

    public static void main(String[] args) {

    }
}
