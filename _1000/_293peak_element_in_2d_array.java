package _1000;

public class _293peak_element_in_2d_array {
    public static int find_max(int mat[][] , int j){
        int max = Integer.Integer.MIN_VALUE;
        int row = 0;
        for(int i = 0; i<mat.length; i++){
            if(mat[i][j] > max){
                max = mat[i][j];
                row = i;
            }
        }
        return row;
    }
    public static int[] peak(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;
        
        int ans[] = new int[2];

        while(low <= high){

            int mid = low + (high -low)/2;

            // first find the row no of maximum element on a current column : 
            int row = find_max(mat , mid);

            // left and right of the mid :
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;

            // if current element is peak : 
            if(mat[row][mid] > left && mat[row][mid] > right){
                ans[0] = row;
                ans[1] = mid;
                break;
            }
            // if mid is present on right :
            if(mat[row][mid] < right){
                low = mid + 1;
            }
            // if mid present on left : 
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String args[]){

    }
}
