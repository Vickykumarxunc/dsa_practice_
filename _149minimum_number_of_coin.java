import java.util.ArrayList;
import java.util.Scanner;

public class _149minimum_number_of_coin {

    // brute force ; :: : 
    public static int min_coin(int n){

        int count = 0;
        while(n != 0){

            if(n >= 10){
                
                n = n - 10;
                count++;
            }
            else if(n >= 5){

                n = n - 5;
                count++;
            }
            else if(n >= 2){

                n = n - 2;
                count++;
            }
            else{
                count ++;
                n = 0;
            }
        }
        return count;
    }
    // optimized : : : ye to hoga count : 
    public static int minimum_coin(int n){

        int count = 0;

        // 10 ke kitne coin : 
        count += n/10;
        n = n % 10;

        // 5 ke kitne coin : 
        count += n/5;
        n = n % 5;

        // 2 ke kitne coin : 
        count += n/2;
        n = n % 2;

        // 1 ke kitne coin : ya n zero hoga : 
        count += n;
        
        return count;
    }

    // n ko kitne {10 , 5 , 2 , 1 } coin me participate kar sakta hoon : 
    public static ArrayList<Integer> minimum_partition(int n){

        // create a array List jo notes ko maintain karegi : 
        ArrayList<Integer> ans = new ArrayList<>();

        // ek coin ka array banao jitne coin me hame n ko partition karna hai : 
        int coin[] = {10 , 5 , 2 , 1};

        // ek variable lo jo coin array par tarverse karege aur sabse acchi choice dega : 
        int i = 0;

        while(n != 0){

            // greedy phele n ko bade notes me split karo : 
            int note = n / coin[i];

            // jitne notes aaye unko ek list me store karlo : 
            while(note-- > 0){
                ans.add(coin[i]);
            }

            // now update the number n : 
            n = n % coin[i];

            // now change the coin  : 
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int n = sc.nextInt();

        int ans = min_coin(n);
        System.out.println("minimum count required of 1 , 2 , 5  10 = " + ans);

        ArrayList<Integer> list = minimum_partition(n);
        System.out.println(list);
    }
}

/*
Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10 } and a target value n. Find the minimum number of coins and/or notes needed to make the change for Rs n. 
 */