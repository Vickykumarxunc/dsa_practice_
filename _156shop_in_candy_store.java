import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class _156shop_in_candy_store {
    public static ArrayList<Integer> minMaxCandy(int prices[] , int k , int n){
        ArrayList<Integer> list = new ArrayList<>();
        
        // first sort the array : 
        Arrays.sort(prices);

        // edge case : 
        if(k == n - 1){
            list.add(prices[0]);
            list.add(prices[n - 1]);
            return list;
        }
        // first find the minimum cost : 
        int i = 0;
        int j = n - 1;
        int min = 0;
        while(i <= j){

            min += prices[i];
            i++;
            j -= k;
        }
        i = 0;
        j = n - 1;
        int max = 0;
        while(i <= j){

            max += prices[j];
            j--;
            i += k;
        }
        list.add(min);
        list.add(max);

        return list;
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
        System.out.println("enter the value of K : ");
        int k = sc.nextInt();
        ArrayList<Integer> list = minMaxCandy(arr, k, n);
        System.out.println(list);
    }
}
/*
In a candy store, there are different types of candies available and prices[i] represent the price of  ith types of candies. You are now provided with an attractive offer.
For every candy you buy from the store, you can get up to k other different candies for free. Find the minimum and maximum amount of money needed to buy all the candies.
Note: In both cases, you must take the maximum number of free candies possible during each purchase.
 */

/*
Input: prices[] = [3, 2, 1, 4], k = 2
Output: [3, 7]
Explanation: As according to the offer if you buy one candy you can take at most k more for free. So in the first case, you buy the candy worth 1 and takes candies worth 3 and 4 for free, also you need to buy candy worth 2. So min cost: 1+2 = 3. In the second case, you can buy the candy worth 4 and takes candies worth 1 and 2 for free, also you need to buy candy worth 3. So max cost: 3+4 = 7.
 */
