import java.util.*;
public class Count_subset_with_K_Sum {
    public static int SubSet(int[]arr,int target){
        int size = arr.length;

        if (target < 0) {
            throw new IllegalArgumentException("Target must be nonnegative.");
        }
        if (size == 0) {
            return target == 0 ? 1 : 0;
        }

        int[][]DP = new int[size][target + 1];

        for(int[]row : DP){
            Arrays.fill(row,-1);
        }

        return Calculate(size - 1,target,arr,DP);
    }

    private static int Calculate(int ind,int target,int[]arr,int[][]DP){
        if(ind == 0){
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if(DP[ind][target] != -1)
            return DP[ind][target];

        int notTake = Calculate(ind - 1,target,arr,DP);
        int take = 0;

        if(arr[ind] <= target){
            take = Calculate(ind - 1,target -arr[ind],arr,DP);
        }

        return DP[ind][target] = take + notTake;

    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3};
        int target = 3;

        System.out.println("Number of subsets with sum " + target + ": " + SubSet(arr, target));
    }
}
