import java.util.*;
public class _3array_leaders {
    public static ArrayList<Integer> leader(int arr[] , int n){

        ArrayList<Integer> list = new ArrayList<>();

        // last element is always the leader :
        list.add(arr[n - 1]);
        
        // last element ko hi greatest maan lo : 
        int greatest = arr[n - 1];

        // traverse the array in reverse order ;
        for(int i = n - 2; i>= 0; i--){
            
            // current element ko greatest element se compare karo 
            // agar current element bada hai to use list me add kar do . 
            // greatest element ko updata kar do :
            if(arr[i] >= greatest){
                greatest = arr[i];
                list.add(arr[i]);
            }
        }
        // return list in reverse order : 
        Collections.reverse(list);
        return list;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = leader(arr, n);
        System.out.println(ans);

    }
}

/*
You are given an array arr of positive integers. Your task is to find all the leaders in the array. 
An element is considered a leader if it is greater than or equal to all elements to its right. 
The rightmost element is always a leader.

Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
 */
