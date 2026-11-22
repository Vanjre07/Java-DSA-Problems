import java.util.*;
public class Insert_Interval_LT57 {
    public static int[][] Intervals(int[][]intervals,int[]newInterval){
        List<int[]> result = new ArrayList<>();

        int index = 0;
        int size = intervals.length;

        while(index < size &&  intervals[index][1] < newInterval[0]){
            result.add(intervals[index]);
            index++;
        }

        while(index < size && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[index][1]);
            index++;
        }

        result.add(newInterval);

        while(index < size){
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};

        int[][]res = Intervals(intervals,newInterval);

        for(int[] num : res){
            System.out.print(Arrays.toString(num) +" ");
        }
    }
}
