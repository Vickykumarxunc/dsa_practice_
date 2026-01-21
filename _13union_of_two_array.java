import java.util.*;
public class _13union_of_two_array {
    public static ArrayList<Integer> union(int arr1[] , int arr2[] , int n , int m){

        // create a hashset to store the value of both the element uniquely : 
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int i : arr2){
            set.add(i);
        }
        // now traverse the hashset and store the value into list : 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : set){
            list.add(i);
        }
        return list;
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
        ArrayList<Integer> ans = union(arr1, arr2, n, m);
        System.out.println(ans);

    }
}
