import java.util.HashMap;
import java.util.Scanner;
public class _130more_than_nbyk_occurances {
    public static int countOccurance(int arr[] , int n , int k){

        // use the hashMap : 
        HashMap<Integer , Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)  + 1);

            if(map.get(arr[i]) > n/k){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element  : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the value of k  : ");
        int k = sc.nextInt();
        int ans = countOccurance(arr, n, k);

        System.out.println(ans);

    }
}
