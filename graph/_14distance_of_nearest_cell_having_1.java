import java.util.LinkedList;
import java.util.Queue;

class Triplet {
    int row;
    int col;
    int dist;

    Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class _14distance_of_nearest_cell_having_1 {

    public static int[][] nearest1(int matrix[][]) {

        // create a queue :
        Queue<Triplet> q = new LinkedList<>();
        int r = matrix.length;
        int c = matrix[0].length;

        // create a visited matrix :
        int visited[][] = new int[r][c];

        // create a ans matrix which contain the distance :
        int ans[][] = new int[r][c];

        // step 1 : first push the all 1(starting point ) in the queue with the distance
        // 0 :
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (matrix[i][j] == 1) {
                    q.add(new Triplet(i, j, 0));

                    // mark as visited and distance is zero :
                    visited[i][j] = 1;
                }
            }
        }

        // to traverse the neighbour in four direction : 
        int delrow[] = {-1 , 0 , 1 , 0};
        int delcol[] = {0 , 1 , 0 , -1};

        // now traverse the queue : 
        while(!q.isEmpty()){

            // remove the first source node : 
            Triplet curr = q.remove();
            int r1 = curr.row;
            int c1 = curr.col;
            int dist = curr.dist;

            // add into the distance ans matrix : 
            ans[r1][c1] = dist;

            // traverse the neighbour in four direction  : 
            for(int i = 0; i<4; i++){
                int newrow = r1 + delrow[i];
                int newcol = c1 + delcol[i];

                // check the valid condtion  : 
                if(newrow >= 0 && newcol >= 0 && newrow < r && newcol < c && visited[newrow][newcol] == 0){

                    // add into the queue with the distance + 1 : 
                    // and mark the visited : 
                    q.add(new Triplet(newrow , newcol , dist + 1));
                    visited[newrow][newcol] = 1;

                }
            } 
        }
        return ans;
    }

    public static void main(String[] args) {

        int matrix[][] = {
            {0 , 1 , 1 , 0},
            {1 , 1 , 0 , 0},
            {0 , 0 , 1 , 1}
        };

        int ans[][] = nearest1(matrix);

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
