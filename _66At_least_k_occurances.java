import java.util.*;
public class _66At_least_k_occurances {
    public static int koccurance(int arr[] , int n , int k){

        // use the hash Map : 
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0 ) + 1);
            if(map.get(arr[i]) >= k){
                return arr[i];
            }
        }
        // agar koi element k times present nahi hai : 
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the value of k ; ");
        int k = sc.nextInt();

        int ans = koccurance(arr, n, k);
        System.out.println(ans);
    }
}
