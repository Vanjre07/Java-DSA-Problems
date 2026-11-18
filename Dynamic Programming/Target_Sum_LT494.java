import java.util.*;
public class Target_Sum_LT494 {
    private static int Sum(int[]nums,int target){
        int size = nums.length;
        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum < Math.abs(target) || (sum + target) %2 != 0)
            return 0;

        int newTarget = (sum + target) / 2;
        int [][]DP = new int[size][newTarget + 1];

        for(int[]row : DP)
            Arrays.fill(row, -1);

        return Solve(size - 1,newTarget,nums,DP);
    }

    private static int Solve(int ind,int target,int []nums,int [][]DP){

        if(ind == 0) {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target)    return 1;
            return 0;
        }

        if(DP[ind][target] !=  -1)
            return DP[ind][target];

        int NotTake = Solve(ind - 1,target,nums,DP);
        int take = 0;

        if(nums[ind] <= target){
            take = Solve(ind - 1,target - nums[ind],nums,DP);
        }

        return DP[ind][target] = take + NotTake;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println("Number of ways: " + Sum(nums, target));
    }
}
