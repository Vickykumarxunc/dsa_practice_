import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class _28alien_dictionary {
    public static String findOrder(String dict[] , int n , int k){

        // first create a adjacency list from the given dictionary : 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<k; i++){
            list.add(new ArrayList<>());
        }

        // traverse the given list : 
        // one by one pair compare karo : 
        // jaishe hi different character milta hai dict[i] != dict[i + 1] to s1 -> s2 connection create karo : 
        for(int i = 0; i<n-1; i++){

            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length() , s2.length());
            
            // find the first uncommon character : 
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){

                    // each alphabet is represented by a number : 
                    // a b c d e f g h i j k l m n o p
                    // 0 1 2 3 3 4 5 6 7 8 9 ...... and so on 
                    list.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    
                    // jaishe hi first uncommon character mile link create karke vahi stop ho jao : 
                    break;
                }
            }
        }
        // now create a ans : 
        ArrayList<Integer> topo = toposort(list, k);
        String ans =  "";
        for(int i : topo){
            ans += (char)(i + 'a');
        }
        return ans;
    }
    // to find the valid order based on the alien dictinory simple apply the topological sort : 
    public static ArrayList<Integer> toposort(ArrayList<ArrayList<Integer>> list , int v){
        
        // first calculate the indegree of each node : 
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int neighbour : list.get(i)){
                indegree[neighbour]++;
            }
        }
        // use the queue : 
        Queue<Integer> q = new LinkedList<>();

        // queue me ve saare node push kar do jiski indegree zero hai : 
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        //create a ans list which store the toposort : 
        ArrayList<Integer> topo = new ArrayList<>();
        // ab queue ko traverse karo : 
        while(!q.isEmpty()){

            int node = q.remove();
            topo.add(node);

            // ab neighbour se link break karo 
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        String dict[] = {"baa" , "abcd" , "abca" , "cab" , "cad"};
        int n = dict.length;
        int k = 4;

        String ans = findOrder(dict,n , k);
        System.out.println("alien order = " + ans);
    }
}
