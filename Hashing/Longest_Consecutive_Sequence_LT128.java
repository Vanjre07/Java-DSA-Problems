import java.util.*;
public class Longest_Consecutive_Sequence_LT128 {
    public static int ConsecutiveElements(int[]nums){
        int n = nums.length;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        if(n < 1) return 0;

        for(int num:nums){
            set.add(num);
        }

        for(int Value:set){
            if(set.contains(Value - 1)) continue;

            int currentLength = 1;
            int NextValue = Value + 1;

            while(set.contains(NextValue)){
                currentLength++;
                NextValue++;
            }
            longest = Math.max(longest,currentLength);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[]nums = {100, 4, 200, 1, 3, 2, 2, 5};

        System.out.print(ConsecutiveElements(nums));
    }
}
