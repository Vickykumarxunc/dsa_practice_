
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
public class _10flood_fill {
    public static int[][] floodfill(int image[][] , int sr , int sc , int newcolor){

        int r = image.length;
        int c = image[0].length;
        // create a visited matrix : 
        int ans[][] = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                ans[i][j] = image[i][j];
            }
        }

        // initial color : 
        int initialcolor = image[sr][sc];

        // traverse the in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        // apply the dfs : 
        dfs(image , ans , initialcolor , newcolor , sr , sc , delrow , delcol);

        // return the ans : 
        return ans;
    }
    public static void dfs(int image[][] , int ans[][] , int initialcolor , int newcolor , int sr , int sc , int delrow[] , int delcol[]){

        // boundary condition and base case : 
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != initialcolor || ans[sr][sc] == newcolor){
            return;
        }
        
        // mark the neighbour as visited : 
        ans[sr][sc] = newcolor;

        // traverse the neighbour : 
        for(int i = 0; i<4; i++){
            int newrow = sr + delrow[i];
            int newcol = sc + delcol[i];
            
            dfs(image , ans , initialcolor , newcolor , newrow , newcol , delrow , delcol);
            // bfs(image , ans , intitialcolor , newcolor , newrow , newcol , delrow , delcol);
        }
    }
    // usin the bfs : 
    public static void bfs(int image[][] , int ans[][] , int initialcolor , int newcolor , int sr , int sc , int delrow[] , int delcol[]){

        Queue<Pair> q = new LinkedList<>();
        // add the first entry in the queeu :
        q.add(new Pair(sr , sc));
        // mark as visited : 
        ans[sr][sc] = newcolor;
        
        // traverse the queue : 
        while(!q.isEmpty()){

            // pop the first entry : 
            Pair pair = q.remove();
            int row = pair.first;
            int col = pair.second;

            // check the neight : 
            for(int i = 0; i<4; i++){
                
                int newrow = row + delrow[i];
                int newcol = col + delcol[i];

                // check the valid condition : 
                if(newrow >= 0 && newcol >= 0 && newrow < image.length && newcol < image[0].length && image[newrow][newcol] == initialcolor && ans[newrow][newcol] != newcolor){
                    q.add(new Pair(newrow , newcol));
                    
                    // mark as visited : 
                    ans[newrow][newcol] = newcolor;
                }
            }
        }  
    }
    public static void main(String[] args) {
        int image[][] = {
            {1 , 1 , 1},
            {2 , 2 , 0},
            {2 , 2 , 2}
        };

        int sr = 2;
        int sc = 0;
        int newcolor = 3;
        int ans[][] = floodfill(image, sr , sc , newcolor);
        
        for(int i = 0; i<ans.length; i++){
            for(int j = 0; j<ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
