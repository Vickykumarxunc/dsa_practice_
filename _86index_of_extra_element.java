import java.util.Scanner;

public class _86index_of_extra_element {

    // linear search : 
    public static int findExtra(int arr1[] , int arr2[]){

        // take the two pointer : 
        int i = 0;

        while(i < arr1.length){

            // agar array ke beech me koi extra element hai : 
            if(arr1[i] != arr2[i]){
                return i;
            }
            // agar same element hai to aage bad jao : 
            i++;
        }
        // agar last element mis match hai : 
        return arr1.length - 1;
    }
    
    // binary search : 
    public static int findextra(int arr1[] , int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int low = 0;
        int high = m - 1;

        // agar last element hi extra ho : 
        if(arr1[n - 1] != arr2[m - 1]){
            return n - 1;
        }

        // now apply the binary search : 
        while(low <= high){
            int mid = low + (high - low)/2;

            // matlab mid le left me koi bhi extra element nahi hai : 
            if(arr1[mid] == arr2[mid]){
                low = mid + 1;
            }
            else{
                // agar mid element mid ke right me hai : 
                high = mid - 1;
            }
        }
        // low pointer extra element par point karege last me : 
        return low;
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
        int ans = findExtra(arr1, arr2);
        System.out.println("index of the extra element : = " + ans);

    }
}
/*
You have given two sorted arrays arr1[] & arr2[] of distinct elements. The first array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.
 */
