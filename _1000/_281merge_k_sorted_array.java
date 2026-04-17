package _1000;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _281merge_k_sorted_array {
    /*
     * every array is already sorted hai
     * to har ek array ka element us array ka minimum element hoga
     * to hum har ek array ke first element ko comapre karege aur usme se minimum
     * element uthalege
     */
    /*
     * hum ek heap banaye ge of size k
     * step 1 : phle heap me har ek array ek first element ko push karo like (value
     * , arrayIndex , valueIndex);
     * step2 : minimum lege ans me add karege
     * step3 : jis array ka minimum element lege us array ka next element heap me
     * push karge :
     * repeat these three step until heap is not empty :
     */
    public static class triplet {
        int value;
        int arr_index;
        int value_index;

        triplet(int value, int arr_index, int value_index) {
            this.value = value;
            this.arr_index = arr_index;
            this.value_index = value_index;
        }
    }

    public static ArrayList<Integer> merge_k_sorted_array(int arr[][]) {

        // step 1 : create a min heap of size K and put the first element of each array
        // :
        PriorityQueue<triplet> pq = new PriorityQueue<>((a , b) -> a.value - b.value);
        for (int i = 0; i < arr.length; i++) {
            pq.add(new triplet(arr[i][0], i, 0));
        }

        ArrayList<Integer> list = new ArrayList<>();

        // step 2 : heap se minimum element nikalo answer me add karo :
        while (!pq.isEmpty()) {

            triplet curr = pq.remove();

            int element = curr.value;
            list.add(element);

            int next_idx = curr.value_index + 1;

            // step 3 : push the next element of same array :
            if (next_idx < arr[curr.arr_index].length) {
                pq.add(new triplet(arr[curr.arr_index][next_idx], curr.arr_index, next_idx));
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
