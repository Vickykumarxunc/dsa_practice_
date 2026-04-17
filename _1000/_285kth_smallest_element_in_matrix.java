package _1000;

import java.util.PriorityQueue;

public class _285kth_smallest_element_in_matrix {
    public static class triplet{
        int value;
        int row;
        int col;
        triplet(int value , int row , int col){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    // matrix are sorted in row and column wise : 
    public static int kth_smallest(int arr[][] , int k){

        // create a min heap 
        // and put the first element of each row : 
        PriorityQueue<triplet> pq = new PriorityQueue<>((a , b)-> a.value - b.value);
        for(int i = 0; i<arr.length; i++){
            pq.add(new triplet(arr[i][0] , i , 0));
        }
        // ab k iteration karo heap par 
        // mimimum element pop karo use next element push karo : 
        int ans = 0;
        while(k > 0){
            triplet curr = pq.remove();
            ans = curr.value;
            k--;

            if(curr.col + 1 < arr[curr.row].length){
                pq.add(new triplet(arr[curr.row][curr.col + 1] , curr.row , curr.col + 1));
            }
        }
        return ans;
    }
   public static void main(String args[]){

   } 
}
