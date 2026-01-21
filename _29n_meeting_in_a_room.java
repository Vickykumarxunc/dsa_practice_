
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _29n_meeting_in_a_room {
    
    // create a pair class for the meeting : 
    public static class meeting{
        int start;
        int end;
        meeting(int start , int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int n_meeting(int start[] , int end[] , int n){

        // phle ek list bana lo jisme har meeting ka starting and end time hoga : 
        ArrayList<meeting> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new meeting(start[i] , end[i]));
        }
        // ab list ko end time ke basis par inceasing order me sort kar do : 
        // jisse ye hoga ki kam time wali meeting phle hi khatam ho jayegi : 
        Collections.sort(list , (a , b) -> a.end - b.end);

        // condition for the next meeting ;
        // agar next meeting ka start time previous meeting ke end time se bada hai tabhi next meeting start hogi : 
        // ek time me ek hi meeting hogi : 
        int count = 1;
        int last_end = list.get(0).end;
        for(int i = 1; i<n; i++){
            
            if(list.get(i).start > last_end){
                count++;
                last_end = list.get(i).end;
            }
        }
        // number of list occur in the room : 
        return count; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();

        System.out.println("enter the start time of the meeting : ");
        int start[] = new int[n];
        for(int i = 0; i<n; i++){
            start[i] = sc.nextInt();
        }
        System.out.println("enter the ending time of the meeting : ");
        int end[] = new int[n];
        for(int i = 0; i<n; i++){
            end[i] = sc.nextInt();
        }
        int ans = n_meeting(start, end, n);
        System.out.println("number of meeting complete =  " + ans);
    }
}
