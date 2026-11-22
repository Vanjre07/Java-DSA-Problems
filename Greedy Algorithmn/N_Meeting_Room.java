import java.util.*;
public class N_Meeting_Room {
    public static int Meeting(int[]start,int[]end){
        int n = start.length;
        if(n == 0)  return 0;

        int[][]Meet = new int[n][3];

        for(int index = 0; index < n; index++){
            Meet[index][0] = index + 1;
            Meet[index][1] = start[index];
            Meet[index][2] = end[index];
        }

        Arrays.sort(Meet,(a,b) -> Integer.compare(a[2],b[2]));

        int count = 1;
        int freeTime = Meet[0][2];
        List<Integer> Pos = new ArrayList<>();
        Pos.add(Meet[0][2]);

        for(int index = 1; index < n; index++){
            if(Meet[index][1] > freeTime){
                count++;
                freeTime = Meet[index][2];
            }
            else Pos.add(Meet[index][0]);
        }

        return count;
    }

    public static void main(String[] args) {
        int[]Start = {1, 3, 0, 5, 8, 5};
        int[]End = {2, 4, 6, 7, 9, 9};

        System.out.print(Meeting(Start,End));
    }
}
