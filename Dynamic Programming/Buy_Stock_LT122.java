import java.util.*;
public class Buy_Stock_LT122 {
    public static int MaxProfit(int[]prices){
        int size = prices.length;
        int[][]DP = new int[size][2];

        for(int[] first : DP){
            Arrays.fill(first,-1);
        }

        return CalculateProfit(0,1,size,prices,DP);
    }

    private static int CalculateProfit(int ind,int buy,int size,int[]prices,int[][]DP){
        if(ind == size)
            return 0;

        int profit;
        if(DP[ind][buy] != -1)
            return DP[ind][buy];

        if(buy == 1){
            int TBuy = -prices[ind] + CalculateProfit(ind + 1,0,size,prices,DP);
            int NotBuy = CalculateProfit(ind + 1,1,size,prices,DP);
            profit = Math.max(TBuy,NotBuy);

        }
        else{
            int TBuy = prices[ind] + CalculateProfit(ind + 1,1,size,prices,DP);
            int NotBuy = CalculateProfit(ind + 1,0,size,prices,DP);
            profit = Math.max(TBuy,NotBuy);
        }

        DP[ind][buy] = profit;

        return DP[ind][buy];
    }

    public static void main(String[] args) {
        int[]prices = {7,1,5,3,6,4};

        System.out.print(MaxProfit(prices));
    }
}
