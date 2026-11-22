import java.util.*;
public class Non_Overlapping_Interval_LT435 {
    private static int Overlapping(int[][]intervals){
        int size = intervals.length;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));

        int count = 1;
        int lastEndTime = intervals[0][1];
        for(int index = 0; index < size;index++){
            if(intervals[index][0] >= lastEndTime){
                count++;
                lastEndTime = intervals[index][1];
            }
        }

        return Math.abs(count - size);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println(Overlapping(intervals));
    }
}
