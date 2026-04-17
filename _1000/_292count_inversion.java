package _1000;

public class _292count_inversion {
    public static int count_and_merge(int arr[] , int low , int mid , int high){

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i = 0; i<n1; i++){
            left[i] = arr[low + i];
        }
        for(int i = 0; i<n2; i++){
            right[i] = arr[mid + 1 + i];
        }
        int result = 0;
        int i = 0;
        int j = 0;
        int k = low;

        while(i < n1 && j < n2){

            // no increment in inversion count 
            // if left has a smaller or equal element : 
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            // if right is smaller , then it is smaller than ni - i 
            // element because left is sorted : 
            else{
                arr[k++] = right[j++];
                result += (n1 - i);
            }
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
        return result;
    }
    public static int count(int arr[] , int low , int high){
         int result = 0;
         if(low < high){
            int mid = low + (high - low)/2;

            // recursively count the inversion in the left and right : 
            result += count(arr , low , mid);
            result += count(arr , mid + 1 , high);

            // count inversion such that greater element is in the left half and smaller in the right half : 
            result += count_and_merge(arr , low , mid , high);
         }
         return result;
    }
    public static int countInversion(int arr[]){
        return count(arr , 0 , arr.length - 1);
    }
    public static void main(String args[]){

    }
}
