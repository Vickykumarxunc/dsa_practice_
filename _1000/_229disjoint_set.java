package _1000;
import java.io.*;
import java.util.*;

// create a data structure that is disjoint :
class DisjointSet{

    // create a rank array and parent array 
    // initially rank array is initialize by zero 
    // intitially every node is a parent of itself : 
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    // initialize : : : : 
    public DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    // function to find the ultimate parent 
    // and compress the path :  
    public int find_ulti_parent(int node){

        // if we reach of the top most ultimate parent 
        // turn return it  
        if(node == parent.get(node)){
            return node;
        }
        // go to the top most ultimate parent and compress the path : 
        int ulp = find_ulti_parent(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    // find the union by rank : 
    public void find_union_by_rank(int u , int v){
        int ulp_u = find_ulti_parent(u);
        int ulp_v = find_ulti_parent(v);

        // if u and v belong to the same component : 
        if(ulp_u == ulp_v){
            return;
        }
        // if they belong to the different component : 
        // the find the rank and add the smaller rank to the larger rank
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v , ulp_u);
        }
        // if rank is equal : 
        else{
            parent.set(ulp_v , ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u , rankU + 1); 
        }
    }
    // find union by size : 
    public void find_union_by_size(int u , int v){
        int ulp_v = find_ulti_parent(u);
        int ulp_u = find_ulti_parent(v);

        // if u and v belong to the same component do nothing 
        if(ulp_v == ulp_v){
            return;
        }
        // smaller size component connect with the largest size componenet : 
        if(size.get(ulp_v) < size.get(ulp_u)){
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_v , ulp_u);
        }
        else if(size.get(ulp_u) < size.get(ulp_v)){
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
            parent.set(ulp_u , ulp_v);
        }
    }
}
 

public class _229disjoint_set {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.find_union_by_rank(1 , 2);
        ds.find_union_by_rank(2, 3);
        ds.find_union_by_rank(4, 5);
        ds.find_union_by_rank(6, 7);
        ds.find_union_by_rank(5, 6);

        // if 3 and 7 same or not : 
        if(ds.find_ulti_parent(3) == ds.find_ulti_parent(7)){
            System.out.println("same");
        }
        else{
            System.out.println("not same : ");
        }

        ds.find_union_by_rank(3, 7);
        if(ds.find_ulti_parent(3) == ds.find_ulti_parent(7)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }

    }
}
