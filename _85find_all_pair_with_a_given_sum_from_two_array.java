import java.util.*;
public class _85find_all_pair_with_a_given_sum_from_two_array {
    public static ArrayList<ArrayList<Integer>> allPair(int arr1[] , int arr2[] , int target){

        int n = arr1.length;
        int m = arr2.length;

        // first sort the both array : 
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // take the two pointer : 
        int i = 0;
        int j  = m - 1;

        while(i < n && j >= 0){

            int sum = arr1[i] + arr2[j];
            if(sum == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr1[i]);
                pair.add(arr2[j]);
                list.add(pair);
                i++;
                j--;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the first array : ");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("enter the element of the first array : ");
        for(int i = 0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("enter the size of the second array : ");
        int m = sc.nextInt();
        int arr2[] = new int[m];
        System.out.println("enter the element of the second array : ");
        for(int i = 0; i<m; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = allPair(arr1, arr2, target);
        System.out.println(ans);

        

    }
}
