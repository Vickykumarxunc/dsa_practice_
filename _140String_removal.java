import java.util.HashSet;
import java.util.Scanner;

public class _140String_removal {
    public static String remove_duplicate(String str, int n) {

        // we use the hashSet to store the unique element :
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        // traverse the String :
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            // check karo current element phle to nahi aaya
            if (!set.contains(ch)) {
                ans.append(ch);

                // mark as visited
                set.add(ch);
            }
        }
        return ans.toString();
    }

    // method 2 by using the frequency array :
    public static String remove_duplicate2(String str, int n) {

        // create a frequency array of the size 255 :
        int freq[] = new int[255];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int ascii = (int) (str.charAt(i));
            if (freq[ascii] == 0) {

                ans.append(str.charAt(i));

                // mark as visited :
                freq[ascii] = 1;

            }
        }
        return ans.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String s = sc.nextLine();
        int n = s.length();

        String ans = remove_duplicate(s, n);
        System.out.println(ans);
    }
}
