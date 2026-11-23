import java.util.*;
public class Min_Platforms_Req_LT2406 {
    public static int Platform(int[][]intervals){
        int n = intervals.length;
        int[]arr = new int[n];
        int[]dep = new int[n];

        int count = 0;
        int max = 0;
        int i = 0,j = 0;
        for(int index = 0; index < n; index++){
            arr[index] = intervals[index][0];
        }

        for(int index = 0; index < n; index++)
            dep[index] = intervals[index][1];

        Arrays.sort(arr);
        Arrays.sort(dep);

        while(i < n){
            if(arr[i] <= dep[j]){
                i++;
                count++;
            }
            else{
                count--;
                j++;
            }
            max = Math.max(max,count);
        }

        return max;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};

        System.out.print(Platform(intervals));
    }
}
