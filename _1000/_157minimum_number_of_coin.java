package _1000;
import java.util.ArrayList;

public class _157minimum_number_of_coin { 

    /*
    Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10 } and a target value n. Find the minimum number of coins and/or notes needed to make the change for Rs n. 
     */
    public static int min_coin(int n){
        int count = 0;
        count += n/10;
        n = n % 10;

        count += n/5;
        n = n % 5;

        count += n/2;
        n = n%2;

        count += n;
        return count;
    }

    public static ArrayList<Integer> min_partition(int n){
        int currency[] = {2000 , 500 , 200 , 100 , 50 , 10 , 5 , 2 , 1};
        ArrayList<Integer> list = new ArrayList<>();
        
        int note = 0;
        int i = 0;

        while(n != 0){
            note = n/currency[i];
            while(note-- != 0){
                list.add(currency[i]);
            }
            n = n % currency[i];
            i++;
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
