import java.util.*;
public class Buy_Stocks3_LT123 {

    public static int BuyStacks(int[]prices){
        int size = prices.length;
        int [][][]DP = new int[size][2][3];

        for(int [][]firstRow : DP){
            for(int[]secondRow : firstRow){
                Arrays.fill(secondRow,-1);
            }
        }
        int Limit = 2;
        return CalculateProfit(0,1,Limit,size,prices,DP);
    }

    public static int CalculateProfit(int ind,int buy,int Limit,
                                      int size,int[]prices,int[][][]DP){
        if(ind == size || Limit == 0)
            return 0;

        if(DP[ind][buy][Limit] != -1)
            return DP[ind][buy][Limit];

        int profit;
        if(buy == 1){
            int BuyStock = -prices[ind] + CalculateProfit(ind + 1,0,Limit,size,prices,DP);
            int NotBuy = CalculateProfit(ind + 1,1,Limit,size,prices,DP);
            profit = Math.max(BuyStock,NotBuy);
        }
        else {
            int SellStocks = prices[ind] + CalculateProfit(ind + 1,1,Limit - 1,size,prices,DP);
            int NotSell = CalculateProfit(ind + 1,0,Limit,size,prices,DP);
            profit = Math.max(SellStocks,NotSell);
        }

        DP[ind][buy][Limit] = profit;

        return DP[ind][buy][Limit];
    }

    public static void main(String[] args) {
        int[]prices = {3,3,5,0,0,3,1,4};
        System.out.print(BuyStacks(prices));
    }
}
