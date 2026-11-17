import java.util.*;
public class Last_Stone_Weight_LT1049 {

    public static int Subset_Sum(int[]stones){
        int size = stones.length;
        int sum = 0;

        for(int num : stones)
            sum += num;

        int target = sum / 2;
        int[][]DP = new int[size][target + 1];

        for(int []row : DP)
            Arrays.fill(row,-1);

        return sum - 2 * Calculate(size - 1,target,stones,DP);
    }

    private static int Calculate(int ind,int target,int []stones,int[][]DP){
        if(ind == 0){
            if(stones[0] <= target)
                return stones[0];
            return 0;
        }

        if(DP[ind][target] != -1)
            return DP[ind][target];

        int NotTake = Calculate(ind - 1,target,stones,DP);
        int Take = 0;

        if(stones[ind] <= target){
            Take = stones[ind] + Calculate(ind - 1,target - stones[ind],stones,DP);
        }

        return DP[ind][target] = Math.max(Take,NotTake);
    }
    public static void main(String[] args) {
        int[]stones = {2,7,4,1,8,1};

        System.out.print(Subset_Sum(stones));
    }
}
