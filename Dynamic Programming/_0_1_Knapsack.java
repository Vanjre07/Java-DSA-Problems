import java.util.*;
public class _0_1_Knapsack {
    public static int Knapsack(int[]val,int[]wt,int Weight){
        int size = val.length;

        int[][]DP = new int[size][Weight + 1];

        for(int []row : DP){
            Arrays.fill(row,-1);
        }

        return Calculate(size - 1,val,wt,Weight,DP);
    }

    private static int Calculate(int ind,int[]val,int[]wt,int weight,int[][]DP){
        if(ind == 0){
            if(wt[0] <= weight) return val[0];
            return 0;
        }

        if(DP[ind][weight] != -1)
            return DP[ind][weight];

        int notTake = Calculate(ind - 1,val,wt,weight,DP);
        int Take = Integer.MIN_VALUE;

        if(wt[ind] <= weight){
            Take = val[ind] + Calculate(ind - 1,val,wt,weight - wt[ind],DP);
        }

        return DP[ind][weight] = Math.max(Take,notTake);
    }
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        if (values.length != weights.length) {
            throw new IllegalArgumentException("Values and weights must have the same length.");
        }

        System.out.println("Maximum value: " + Knapsack(values, weights, capacity));
    }
}
