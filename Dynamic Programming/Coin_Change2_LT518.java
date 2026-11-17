import java.util.*;
public class Coin_Change2_LT518 {
    public static int Coin(int[]coins,int amount){
        int size = coins.length;
        int [][]DP = new int[size][amount + 1];

        for(int []row : DP)
            Arrays.fill(row,-1);

        return Calculate(size - 1,amount,coins,DP);
    }

    private static int Calculate(int ind,int amount,int[]coins,int[][]DP){
        if(amount == 0)
            return 1;

        if(ind == 0)
            return amount % coins[0] == 0 ? 1 : 0;

        if(DP[ind][amount] != -1)
            return DP[ind][amount];

        int NotTake = Calculate(ind - 1,amount,coins,DP);
        int Take = 0;
        if(coins[ind] <= amount)
            Take = Calculate(ind,amount - coins[ind],coins,DP);

        return DP[ind][amount] = Take + NotTake;
    }
    public static void main(String[] args) {
        int[]coins = {1,2,5};
        int amount = 5;

        System.out.print(Coin(coins,amount));
    }
}
