package _1000;

public class _329pascal_triangle_2 {
    public static ArrayList<Integer> pascaltriangle(int rowIndex){

        ArrayList<Integer> list = new ArrayList<>();
        int prev = 1; // c(n , 0) = 1;
        list.add(1);

        for(int i = 1; i<=rowIndex; i++){
            int curr = (prev * (rowIndex - i + 1))/i;
            list.add(curr);
            prev = curr;
        }
        return list;
    }
    public static void main(String args[]){
    }
}
