import java.util.*;
public class Subset_Sum_Equals_Target {
    public static boolean Sum(int[]arr,int k){
        int size = arr.length;
        int[][]DP = new int[size][k + 1];

        for(int []Row : DP){
            Arrays.fill(Row,-1);
        }

        return Calculate(size - 1,size,k,arr,DP);
    }

    private static boolean Calculate(int ind,int size,int target,int[]arr,int[][]DP){
        if(ind == 0)
            return arr[0] == target;

        if(target == 0)
            return true;

        if(DP[ind][target] != -1)
            return DP[ind][target] == 1;

        boolean notTaken = Calculate(ind - 1,size,target,arr,DP);

        boolean Taken = false;

        if(arr[ind] <= target){
            Taken = Calculate(ind - 1,size,target - arr[ind],arr,DP);
        }

        DP[ind][target] = notTaken || Taken ? 1 : 0;

        return DP[ind][target] == 1;
    }
    public static void main(String[] args) {
        int[]arr = {1, 2, 7, 3};
        int target = 6;

        System.out.print(Sum(arr,target));

    }
}
