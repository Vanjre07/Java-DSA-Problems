package Hard_Level;
import java.util.*;
public class Find_Missing_and_Repeating_Number {
    static class BruteForce {
        public static int[] MissingNumber(int[] nums) {
            int reapting = -1;
            int missing = -1;
            for (int i = 1; i <= nums.length; i++) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == i)
                        count++;
                }
                if (count == 2) reapting = i;
                else if (count == 0) missing = i;
            }

            return new int[]{missing, reapting};
        }
    }

    static class BetterApproach{
        public static int[] MissingNumber(int[]nums){
            int n = nums.length;
            int []hash = new int[n+1];

            for(int i = 0; i < n; i++){
                hash[nums[i]]++;
            }
            int repeating = -1;
            int missing = -1;

            for(int i = 0; i<n; i++){
                if(hash[i] == 2)repeating = i;
                else if(hash[i] == 0)missing = i;
            }

            if(repeating == -1 && missing == -1)
                return null;

            return new int[]{repeating,missing};
        }
    }

    static class Optimal{
        public static int[] MissingNumber(int[] nums) {
            long n = nums.length;
            long Sn = (n*(n+1))/2;
            long s2n = (n*(n+1) * (2*n+1))/6;
            long s=0, s2 = 0;
            for(int i = 0; i<n; i++){
                s+=nums[i];
                s2+=(long) nums[i] * (long)nums[i];
            }

            long val1 = s -Sn;
            long val2 = s2 - s2n;

            val2 = val2/val1;

            long x = (val1+val2)/2;
            long y = x -val1;

            return new int[]{(int)x,(int)y};
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 3};

        System.out.println(Arrays.toString(BruteForce.MissingNumber(nums)));
        System.out.println(Arrays.toString(BetterApproach.MissingNumber(nums)));
        System.out.println(Arrays.toString(Optimal.MissingNumber(nums)));

    }

}
