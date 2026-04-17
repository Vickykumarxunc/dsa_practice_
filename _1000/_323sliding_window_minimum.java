package _1000;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class _323sliding_window_minimum {
    public static ArrayList<Integer> sliding_window_minimum(int arr[] , int n , int k){
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        // hum har ek element ke liye char operation karege : 
        for(int i = 0; i<n; i++){

            // step1 : out of window ke element ko remove karo : 
            if(!dq.isEmpty() && dq.getFirst() <= i - k){
                dq.removeFirst();
            }
            // step2 : current element se saare maximum element remove karo dequeue me se : 
            // hum dequeue ke ander unhi element ka index store karege jo future ke use ho sakte hai (minimum elemnet ka index )
            while(!dq.isEmpty() && arr[i] < arr[dq.getLast()]){
                dq.removeLast();
            }
            //step3 : add the current element index : 
            dq.addLast(i);

            //step 4 : if window is complete add the current window minimum in ans : 
            if(!dq.isEmpty() && i >= k - 1){
                list.add(arr[dq.getFirst()]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
