
import java.util.ArrayList;
import java.util.*;
import java.util.Stack;

class Node{
    Node left;
    Node right;
    Node next;
    int data;
    Node(int data){
        this.data = data;
    }
}
public class _0practice {
    public static int missingelement(int arr[] , int n){
        int m = n + 1;
        int totalsum = (m * (m + 1) ) /2;
        for(int i = 0; i<n; i++){
            totalsum -= arr[i];
        }
        return totalsum;
    }
    public static int secondlargest(int arr[] , int n){
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        for(int i = 0; i<n; i++){
            if(arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] > max2 && arr[i] != max1){
                max2 = arr[i];
            }
        }
        return max2;
    }
    public static ArrayList<Integer> arrayleader(int arr[] , int n){
        ArrayList<Integer> list = new ArrayList<>();
        int leader = arr[n - 1];
        list.add(leader);
        for(int i = n - 2; i>= 0; i--){
            if(arr[i] > leader){
                leader = arr[i];
                list.add(leader);
            }
        }
        return list;
    }
    public static ArrayList<Integer> duplicate(int arr[] , int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0){
                list.add(Math.abs(arr[i]));
            }
            else{
                arr[index] = -1 * arr[index];
            }
        }
        return list;
    }
    public static boolean parenthesischecker(String s , int n){
        Stack<Character> st = new Stack<>();
        char ch[] = s.toCharArray();
        for(int i = 0; i<n; i++){
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '['){
                st.push(ch[i]);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else if((ch[i] == ']' && st.peek() != '[') || (ch[i] == ')' && st.peek() != '(') || ( ch[i] == '}' && st.peek() != '{')){
                    return false;
                }
            }
            st.push(ch[i]);
        }
        return true;
    }
    public static int equilibriumpoint(int arr[] , int n){
        int right_sum = 0;
        for(int i = 0; i<n; i++){
            right_sum += arr[i];
        }
        int left_sum = 0;
        for(int i = 0; i<n; i++){
            right_sum -= arr[i];
            if(left_sum == right_sum){
                return i;
            }
            left_sum += arr[i];
        }
        return -1;
    }
    public static boolean iterativebinarysearch(int arr[] , int n , int target){
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
    public static boolean recursivebinarysearch(int arr[] , int left , int right , int target , int n){
        if(left > right){
            return false;
        }
        int mid = left + (right - left)/2;

        if(arr[mid] == target){
            return true;
        }
        else if(arr[mid] > target){
           return recursivebinarysearch(arr , left , mid - 1 , target , n);
        }
        else{
            return recursivebinarysearch(arr , mid + 1 , right , target , n);
        }
    }
    public static ArrayList<Integer> missingrepeating(int arr[] , int n){
        ArrayList<Integer> list = new ArrayList<>();
        int missing = -1;
        int repeating = -1;
        for(int i = 0; i<n; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0){
                repeating = Math.abs(arr[i]);
            }
            else{
                arr[index] = -1 * arr[index];
            }
        }
        for(int i = 0; i<n; i++){
            if(arr[i] >= 0){
                missing = i + 1;
                break;
            }
        }
        list.add(missing);
        list.add(repeating);
        return list;
    }
    public static ArrayList<Integer> leftview(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        int max[] = new int[]{0};
        findleft(root , list , 0 , max);
        return list;
    }
    public static void findleft(Node root , ArrayList<Integer> list , int level , int max[]){
        if(root == null){
            return;
        }
        if(max[0] < level){
            list.add(root.data);
            level = max[0];
        }
        findleft(root.left , list , level + 1 , max);
        findleft(root.right , list , level + 1 , max);

    }
    public static int floorinsortedarray(int arr[] , int n , int target){
        int floor = -1;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return arr[mid];
            }
            else if(arr[mid] < target){
                floor = arr[mid];
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return floor;
    }
    
    public static void main(String[] args) {

    }
}
