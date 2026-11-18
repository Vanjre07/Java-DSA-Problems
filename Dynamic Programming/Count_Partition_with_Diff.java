import java.util.*;
public class Count_Partition_with_Diff {
    private final static int MOD = 1000000007;
    public static int Partition(int[]arr,int diff){
        int size = arr.length;
        int sum = 0;
        for(int num : arr)
            sum += num;

        int remaining = sum - diff;
        if(remaining < 0 || remaining % 2 != 0)
            return 0;

        int target = remaining / 2;
        int[][]DP = new int[size][target + 1];

        for(int[]row : DP)
            Arrays.fill(row,-1);

        return Solve(size - 1,target,arr,DP);
    }

    private static int Solve(int ind,int target,int[]arr,int[][]DP){
        if(ind == 0){
            if(target == 0 && arr[0] == 0)  return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if(DP[ind][target] != -1)
            return DP[ind][target];

        int NotTake = Solve(ind - 1,target,arr,DP);
        int Take = 0;

        if(arr[ind] <= target)
            Take = Solve(ind - 1,target - arr[ind],arr,DP);

        return DP[ind][target] = (Take + NotTake) % MOD;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        System.out.println("Number of partitions: " + Partition(arr, diff));
    }
}
