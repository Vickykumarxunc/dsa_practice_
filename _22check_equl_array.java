import java.util.*;
public class _22check_equl_array {
    public static boolean check(int arr1[] , int arr2[] , int n , int m){

        // agar dono array ki length different hao to vo equal nahi hai : 
        if(n != m){
            return false;
        }
        // ab hum hashMap use karege jisme hum ek array ke element ko store karege with frequency : 
        HashMap<Integer , Integer> map = new HashMap<>();

        // store the array one in the hashMap : 
        for(int i = 0; i<n; i++){
            map.put(arr1[i] , map.getOrDefault(arr1[i] , 0) + 1);
        }
        // now travese the array 2 : 
        for(int i = 0; i<m; i++){
            if(!map.containsKey(arr2[i]) || map.get(arr2[i]) == 0){
                return false;
            }
            map.put(arr2[i] , map.get(arr2[i]) - 1);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the first array : ");
        int n = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr1[] = new int[n];
        for(int i = 0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("enter the size of the second array : ");
        int m = sc.nextInt();
        System.out.println("enter the array element : ");
        int arr2[] = new int[m];
        for(int i = 0; i<m; i++){
            arr2[i] = sc.nextInt();
        }

        boolean ans = check(arr1 , arr2 , n , m);
        System.out.println("check array is equal or not = " + ans);
    }
}
