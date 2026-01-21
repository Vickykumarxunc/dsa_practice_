
import java.util.*;

public class _56intersection_of_array_with_distinct {

    public static ArrayList<Integer> intersection(int arr1[] , int arr2[] , int n , int m){

        ArrayList<Integer> list = new ArrayList<>();
        // hum hashset use karege 
        // ek array ke element ko hashSet me add kar le ge : 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(arr1[i]);
        }
        // ab array 2 par traverse karege : 
        // aur check karege array2 ka jo element hashset me present hai vo element dono me common hai 
        // use list me addd kr de ge : 
        for(int i = 0; i<m; i++){
            
            if(set.contains(arr2[i])){

                // remove the duplicate element : 
                if(!list.contains(arr2[i])){
                    list.add(arr2[i]);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("enter the size of the second array : ");
        int m = sc.nextInt();
        int arr2[] = new int[m];
        System.out.println("enter the array elemetn : ");
        for(int i = 0; i<m; i++){
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> list = intersection(arr1, arr2, n, m);
        System.out.println(list);
        
    }
}
