package _1000;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class _215word_ladder_1 {
    public static class pair{
        String word;
        int step;
        pair(String word , int step){
            this.word = word;
            this.step = step;
        }
    }
    public static int word_ladder(String StartWord , String targetWord , String WordList[]){
        int n = WordList.length;

        // first push the all word in the set for better search : 
        // in constant time : 
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(WordList[i]);
        }
        // now apply the bfs : 
        // add the start word in the queue with step 1 : 
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(StartWord , 1));

        while(!q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().step;
            q.remove();

            // if i have fount target word : 
            if(word == targetWord){
                return step;
            }
            // check all the possiblilty : 
            // wordlength * 26 * no of word 
            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    
                    // if it is exist in the set : 
                    // then push into the queue and remove from the set : 
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new pair(replacedWord , step + 1));
                    }
                }
            }
        }
        // if we not reach the target word : 
        return 0;
    }
    public static void main(String[] args) {
        
    }
}
