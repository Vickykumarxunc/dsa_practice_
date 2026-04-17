package _1000;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;
class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    int ulp(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = ulp(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    void union(int u , int v){
        int ulp_u = ulp(u);
        int ulp_v = ulp(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
            parent.set(ulp_u , ulp_v);
        }
        else if(size.get(ulp_v) < size.get(ulp_u)){
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_v , ulp_u);
        }
    }
}

public class _233account_merge {

    public static ArrayList<ArrayList<String>> accountmerge(ArrayList<ArrayList<String>> details){
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);

        // create a map 
        // jisme hum har ek emali ko ek index se mapped karege : 
        HashMap<String , Integer> mapMailNode = new HashMap<>();
        for(int i = 0; i<n; i++){
            for(int j = 1; j<details.get(i).size(); j++){
                
                // agar mail phli baar visit hui hai to use map me add karo 
                // with unique number : 
                String mail  = details.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail , i);
                }
                else{
                    // agar mail ko hum dusri baar visite kar rahe hai
                    // to use merge kerege phle wali mail ke sath : 
                    ds.union(i , mapMailNode.get(mail));
                }
            }
        }
        // ab same index wali email ko ek list me push karege 
        // aur jiska ulitimate parent same hoga use bhi ek hi list me push karege ;
        ArrayList<ArrayList<String>> mergeMail = new ArrayList<>();
        for(int i = 0; i<n; i++){
            mergeMail.add(new ArrayList<>());
        }
        // traverse the map : 
        for(Entry<String, Integer> it : mapMailNode.entrySet()){

            // current mail
            String mail = it.getKey();

            // current mail ka ultimate parent 
            int node = ds.ulp(it.getValue()); 

            // put into the list : 
            mergeMail.get(node).add(mail);
        }
        // now create a ans : 
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(mergeMail.get(i).size() == 0){
                continue;
            }
            // sort the mail lexicographically order : 
            Collections.sort(mergeMail.get(i));

            ArrayList<String> temp = new ArrayList<>();
            // first add the name : 
            temp.add(details.get(i).get(0));

            // now add the detail corresponding to the name : 
            for(String it : mergeMail.get(i)){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
         
    }
    public static void main(String[] args) {
        
    }
}
