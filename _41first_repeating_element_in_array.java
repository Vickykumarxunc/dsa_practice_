import java.util.*;
public class _41first_repeating_element_in_array {
    
    public static int first_repeat(int arr[] , int n){

        // phle saare element ko hashMap me store kar lo : 
        HashMap<Integer , Integer> map  = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        // ab first repeating element ko return kr do : 
        for(int i = 0; i<n; i++){
            if(map.get(arr[i]) > 1){
                return i + 1;
            }
        }
        // if repeating element is not present : 
        return -1;
    }
    
    // another efficient approach : 
    public static int find(int arr[] , int n){

        int index = -1;
        HashSet<Integer> set = new HashSet<>();

        // right se left traverse karo : 
        for(int i = n - 1; i>= 0; i--){

            // jo element phle se map me mile wahi sabse pehle repeat hone wala element hoga : 
            if(set.contains(arr[i])){
                index = i + 1;
            }
            set.add(arr[i]);
        }
        
        return index;
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

        int ans = first_repeat(arr, n);
        System.out.println(" position of the first repeating element in the array = " + ans);

    }
}
