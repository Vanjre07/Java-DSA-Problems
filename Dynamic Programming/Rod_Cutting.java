import java.util.Arrays;

public class Rod_Cutting {

    public int RodCutting(int[] price, int n) {
        int size = price.length;
        int[][] dp = new int[size][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return Solve(size - 1, price, n, dp);
    }

    private int Solve(int index, int[] price, int length, int[][] dp) {
        if (length == 0) {
            return 0;
        }

        if (index == 0) {
            return length * price[0];
        }

        if (dp[index][length] != -1) {
            return dp[index][length];
        }

        int notTake = Solve(index - 1, price, length, dp);
        int take = 0;
        int pieceLength = index + 1;

        if (pieceLength <= length) {
            take = price[index] + Solve(index, price, length - pieceLength, dp);
        }

        dp[index][length] = Math.max(take, notTake);
        return dp[index][length];
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10};
        int rodLength = price.length;

        Rod_Cutting rodCutter = new Rod_Cutting();
        System.out.println("Maximum revenue: " + rodCutter.RodCutting(price, rodLength));
    }
}
