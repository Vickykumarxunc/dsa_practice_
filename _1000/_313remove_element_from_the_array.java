package _1000;
public class _313remove_element_from_the_array{
    public static int remove_element(int arr[] , int n , int val){

        // take the two pointer : 
        int j = 0;

        // ek count variable rakho jo given value ki frequency count karega : 
        int count = 0;
        for(int i = 0; i<n; i++){

            // agar value given value ke barabar nahi hai :
            if(arr[i] != val){
                arr[j] = arr[i];
                j++;
            }
            // agar value given value ke equal hai : 
            else{
                count++;
            }
        }
        // length of the array after removing the all occurances of the value val : 
        return n - count;
    }
    public static void main(String args[]){

    }
}