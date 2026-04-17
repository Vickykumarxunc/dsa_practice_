package _1000;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class _216word_ladder_2 {
    public static ArrayList<ArrayList<String>> find_seq(String startWord , String targetWord , String wordlist[]){
        int n = wordlist.length;

        // first add the all word into the set : 
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(wordlist[i]);
        }

        //apply the bfs : 
        // create a queue of the arraylist : 
        Queue<ArrayList<String>> q = new LinkedList<>();

        // add the start word into the queue in the form of list : 
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        // har ek level par string ko store karne ke liye ek list banao : 
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        // to track the level we use the level varaible :
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        // now traverse the queue : 
        while(!q.isEmpty()){
            
            // ab hum queue se har ek word ko pop karo 
            // jo ek list hoga :
            ArrayList<String> vec = q.remove();

            // jab ek level pura traverse ho jaye to pichle level ke saare word set me se remove kar do : 
            if(vec.size() > level){

                // first increase the level : 
                level++;

                // now remove the previous level word
                // jo jo word maine use kar liye use remove kar do ; 
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }
            // ab list ka last word lo aur sare possible create kar ke deko one bye one
            // jon sa set me presnt ho to ek list bana ke use queue me push karo :
            String word = vec.get(vec.size() - 1);
            if(word.equals(targetWord)){

                // the first sequence where we reached end  
                if(ans.size() == 0){
                    ans.add(vec);
                }
                else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }
            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){

                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);

                        // one by one chagees list push into the queue :
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);

                        // mark as visited on the level : 
                        usedOnLevel.add(replacedWord);

                        // for the new possibility :
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
