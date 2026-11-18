import java.util.*;

public class Unbounded_Knapsack {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[][] DP = new int[n][W + 1];

        for (int[] row : DP) {
            Arrays.fill(row, -1);
        }

        return Solve(n - 1, val, wt, W, DP);
    }

    private int Solve(int ind, int[] val, int[] wt, int weight, int[][] DP) {
        if (ind == 0) {
            return weight / wt[0] * val[0];
        }

        if (DP[ind][weight] != -1) {
            return DP[ind][weight];
        }

        int NotTake = Solve(ind - 1, val, wt, weight, DP);
        int Take = 0;
        if (wt[ind] <= weight) {
            Take = val[ind] + Solve(ind, val, wt, weight - wt[ind], DP);
        }

        return DP[ind][weight] = Math.max(Take, NotTake);
    }

    public static void main(String[] args) {
        int[] weights = {2, 4, 6};
        int[] values = {5, 11, 13};
        int capacity = 10;

        Unbounded_Knapsack knapsack = new Unbounded_Knapsack();
        System.out.println(
                "Maximum value: "
                        + knapsack.unboundedKnapsack(weights, values, weights.length, capacity));
    }
}


