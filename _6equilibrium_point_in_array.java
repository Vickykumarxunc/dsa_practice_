import java.util.Scanner;

public class _6equilibrium_point_in_array {
    public static int find(int arr[] , int n){

        // first find the total sum that is the suffix sum : 
        int total_sum = 0;
        for(int i = 0; i<n; i++){
            total_sum += arr[i];
        }
        int right = total_sum;

        // now maintain the left sum : 
        int left = 0;
        for(int i = 0; i<n; i++){
            right = right - arr[i];

            // condition of the equilibrium point : 
            if(left == right){
                return i;
            }
            // maintain the prefix sum : 
            left += arr[i];
        }
        // agar equilibrium point nahi hai to return kar do -1; 
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int equilibrium_point = find(arr , n);
        System.out.println("equilibrium point in the array is = " + equilibrium_point);
        
    }
}
/*
equilibrium point vo point hota hai jiske left aur right me array ka sum equal hota hai : 
 */
