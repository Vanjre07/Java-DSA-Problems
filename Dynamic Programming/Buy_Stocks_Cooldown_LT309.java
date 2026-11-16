import java.util.*;
public class Buy_Stocks_Cooldown_LT309 {

    public static int BuyStock(int[]prices){
        int size = prices.length;
        int[][]DP = new int[size][2];

        for(int[]firstRow : DP){
            Arrays.fill(firstRow,-1);
        }

        return Calculate(0,1,size,prices,DP);
    }

    private static int Calculate(int ind,int buy,int size,int[]prices,int[][]DP){
        if(ind >= size)
            return 0;

        if(DP[ind][buy] != -1)
            return DP[ind][buy];

        int profit;
        if(buy == 1){
            int Buy = -prices[ind] + Calculate(ind + 1,0,size,prices,DP);
            int NotBuy = Calculate(ind + 1,1,size,prices,DP);

            profit = Math.max(Buy,NotBuy);
        }

        else{
            int sell = prices[ind] + Calculate(ind + 2,1,size,prices,DP);
            int NotSell = Calculate(ind + 1,0,size,prices,DP);

            profit = Math.max(sell,NotSell);
        }

        DP[ind][buy] = profit;

        return DP[ind][buy];
    }
    public static void main(String[] args) {
        int[]prices = {1,2,3,0,2};
        System.out.print(BuyStock(prices));
    }
}
