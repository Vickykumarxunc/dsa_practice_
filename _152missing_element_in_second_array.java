import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
public class _152missing_element_in_second_array {
    public static ArrayList<Integer> find_missing(int arr1[] , int arr2[]){

        // ek hashset bana lo ume second array ke element ko push kar do : 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        // ab array 1 par traverse karo : 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<arr1.length; i++){
            
            // agar array 1 ka element array 2 me present nahi hai to use ans me add kar do : 
            if(!set.contains(arr1[i])){
                list.add(arr1[i]);
            }
        }
        return list;
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
        System.out.println("enter the size of second array : ");
        int n2 = sc.nextInt();
        
        System.out.println("enter the second array element : ");
        int arr2[] = new int[n2];
        for(int i = 0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }

        ArrayList<Integer> list = find_missing(arr, arr2);
        System.out.println(list);
    }
}
