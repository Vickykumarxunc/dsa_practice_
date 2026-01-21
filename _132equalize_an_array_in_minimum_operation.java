
import java.util.Arrays;
import java.util.Scanner;

public class _132equalize_an_array_in_minimum_operation {
    public static int findMinOperation(int arr[] , int n , int k){

        // agar hum kisi element x ko kisi value t me convert karna chate hai using +- k 
        // to ye tabhi possible jab : 
        // (x-t) % k == 0
        // matlab kar ek element ko k se divide karne par remainder same aaye ;

        // agar answer possible hai : 
        // problem ko reduce karne ke liye sabhi element ko k se dived kar do aur ek new array create karo 
        // minimum operation ke liye median find karo : 
        
        // step 1 : remainder check: 
        int rem = arr[0] % k;
        for(int i = 0; i<n; i++){
            if(arr[i] % k != rem){
                return -1;
            }
        }

        // step 2 : divied by k : 
        int []temp = new int[n];
        for(int i = 0; i<n; i++){
            temp[i] = arr[i]/k;
        }

        //step 3 :  sort the array : 
        Arrays.sort(temp);

        // step 4 : find the median :
        int median = temp[n/2];

        // step 5 : count move : 
        int move = 0;
        for(int i = 0; i<n; i++){
            move = (move + Math.abs(temp[i] - median)) % 1000000007;
        }
        // return minimum move : 
        return move;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the value of k :");
        int k = sc.nextInt();

        int ans = findMinOperation(arr, n, k);
        System.out.println(ans);
        
    }
}
