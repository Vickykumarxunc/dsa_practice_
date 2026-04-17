package _1000;
public class _52minimum_distance_in_array_between_two_number{
    public static int min_distance(int arr[] , int n , int x , int y){
        int dist = Integer.MAX_VALUE;
        int x_index = -1;
        int y_index = -1;
        for(int i = 0; i<n; i++){
            if(arr[i] == x){
                x_index = i;
            }
            if(arr[i] == y){
                y_index = i;
            }
            if(x_index != -1 && y_index != -1){
                dist = Math.min(dist , Math.abs(x_index - y_index + 1));
            }
        }
        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
    public static void main(String[] args) {
        
    }
}