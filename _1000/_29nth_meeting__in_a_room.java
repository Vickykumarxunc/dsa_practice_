package _1000;

import java.util.ArrayList;
import java.util.Collections;

public class _29nth_meeting__in_a_room {
    public static class Meeting{
        int start;
        int end;
        Meeting(int start , int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int meeting(int start[] , int end[] , int n){
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new Meeting(start[i] , end[i]));
        }
        Collections.sort(list , (a , b)-> a.end - b.end);
        int count  = 1;
        int last = list.get(0).end;
        for(int i = 1; i<n; i++){
            if(list.get(i).start > last){
                count++;
                last = list.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
