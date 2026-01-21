
import java.util.Scanner;

public class _51_minimum_distance_in_array {
    public static int min_distance(int arr[] , int x , int y , int n){

        // first find the index of x and y element : 
        int x_index = -1;
        int y_index = -1;
        int min_distance = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i] == x){
                x_index = i;
            }
            if(arr[i] == y){
                y_index = i;
            }
            if(x_index != -1 && y_index != -1){
                min_distance = Math.min(min_distance , Math.abs(x_index - y_index));
            }
        }
        if(min_distance == Integer.MAX_VALUE){
            return -1;
        }
        return min_distance;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the value of x : ");
        int x = sc.nextInt();
        System.out.println("enter the value of y : ");
        int y = sc.nextInt();

        int ans = min_distance(arr, x, y, n);
        System.out.println("minimum distance between x and y = "  + ans);
        
    }
}
