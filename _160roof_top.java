import java.util.Scanner;

public class _160roof_top {
    public static int max_step(int arr[] , int n){

        int max = -1;
        int count = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] > arr[i - 1]){
                count++;
                max = Math.max(max , count);
            }
            else{
                count = 0;
            }
        }
        return Math.max(max , count);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = max_step(arr , n);
        System.out.println("maximum no of consecutive step = " + ans);

    }
}
/*
You are given the heights of consecutive buildings. You can move from the roof of a building to the roof of the next adjacent building. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.
 */
