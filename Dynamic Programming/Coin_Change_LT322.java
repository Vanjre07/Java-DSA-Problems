import java.util.*;
public class Coin_Change_LT322 {
    public static int Coins(int[]coin,int amount){
        int size = coin.length;
        int[][]DP = new int[size][amount + 1];

        for(int[]row : DP)
            Arrays.fill(row,-1);

        int ans = Solve(size - 1,amount,coin,DP);

        if(ans >= 1000000)  return -1;

        return ans;

    }

    private static int Solve(int ind,int amount,int[]coins,int[][]DP){
        if(ind == 0){
            if(amount % coins[0] == 0)  return amount / coins[0];
            return 1000000;
        }

        if(DP[ind][amount] != -1)
            return DP[ind][amount];

        int NotTake = Solve(ind - 1,amount,coins,DP);
        int Take = 1000000;

        if(coins[ind] <= amount){
            Take = 1 + Solve(ind,amount - coins[ind],coins,DP);
        }

        return DP[ind][amount] = Math.min(NotTake,Take);
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Minimum coins: " + Coins(coins, amount));
    }
}
