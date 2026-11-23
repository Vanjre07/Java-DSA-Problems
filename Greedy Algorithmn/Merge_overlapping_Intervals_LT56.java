import java.util.*;
public class Merge_overlapping_Intervals_LT56 {
    public static int[][]Job(int[][]intervals){
        int size = intervals.length;;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        for(int index = 0; index < size; index++){
            if(result.isEmpty() || result.get(result.size() - 1)[1] < intervals[index][0]){
                result.add(intervals[index]);
            }
            else{
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1],intervals[index][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][]res = Job(intervals);

        for(int[]num : res){
            System.out.println(Arrays.toString(num) +" ");
        }
    }
}
