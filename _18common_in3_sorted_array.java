import java.util.*;
public class _18common_in3_sorted_array {
    public static ArrayList<Integer> common(int arr1[] , int arr2[] , int arr3[] , int n1 , int n2 , int n3){

        ArrayList<Integer> list = new ArrayList<>();
        // take three pointer : 
        int i = 0;
        int j = 0;
        int k = 0;

        // traverse the all three array : 
        while(i < n1 && j < n2 && k < n3){

            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){

                // skip the duplicate element : 
                if(list.contains(arr1[i])){
                    i++;
                    j++;
                    k++;
                }
                else{
                    // agar element list me phle se present nahi hai 
                    // to use list me add kar do : 
                    list.add(arr1[i]);
                }
            }
            // increase the i pointer : 
            else if(arr1[i] < arr2[j]){
                i++;
            }
            // increase the j pointer : 
            else if(arr2[j] < arr3[k]){
                j++;
            }
            // increase the k pointer : 
            else{
                k++;
            }
        }
        if(list.isEmpty()){
            list.add(-1);
            return list;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the first array : ");
        int n1 = sc.nextInt();
        System.out.println("enter the first array element : ");
        int arr1[] = new int[n1];
        for(int i = 0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("enter the second array size : ");
        int n2 = sc.nextInt();
        System.out.println("enter the second array element : ");
        int arr2[] = new int[n2];
        for(int i = 0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println("enter the third array size : ");
        int n3 = sc.nextInt();
        System.out.println("enter the third array element : ");
        int arr3[] = new int[n3];
        for(int i = 0; i<n3; i++){
            arr3[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = common(arr1, arr2, arr3, n1, n2, n3);
        System.out.println(ans);

        
    }
}
