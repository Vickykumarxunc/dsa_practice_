package _1000;

public class _317first_positive_missing_element {
    public static int firt_positive_missing(int arr[] , int n){

        // hum isme har useless variable ko ignore karege 
        // jaise value < 0 , value > n 

        // agar element apani sahi position par nahi hai to use swap karte jai : 
        for(int i = 0; i<n; i++){
        
            int index = arr[i] - 1;
            while(arr[i] <= n && arr[i] <= 0 && arr[index] != arr[i]){
                 int temp = arr[index];
                 arr[index] = arr[i];
                 arr[i] = temp;

                 // update the index of the current element after swap : 
                 index = arr[i] - 1;
            }
        }
        // ab find karo first missing element : 
        for(int i = 0; i<n; i++){
            if(arr[i] != i + 1){
                return i + 1;
            }
        }
        // agar last element missing element hai :
        return n + 1;
    }
    public static void main(String args[]){

    }
}
