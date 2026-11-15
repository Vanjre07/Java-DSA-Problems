import java.util.*;
public class Buy_Stocks4_LT124 {

    public static int BuyStocks(int k,int[]prices){
        int n = prices.length;
        int[][][]DP = new int[n][2][k+1];

        for(int[][]firstRow : DP){
            for(int[]secondRow : firstRow){
                Arrays.fill(secondRow,-1);
            }
        }

        return CalculateProfit(0,1,k,n,prices,DP);
    }

    private static int CalculateProfit(int ind,int buy,int Limit,int Size,int[]prices,int [][][]DP){
        if(ind == Size || Limit == 0)
            return 0;

        if(DP[ind][buy][Limit] != -1)
            return DP[ind][buy][Limit];

        int profit;

        if(buy == 1){
            int BuyStock = -prices[ind] + CalculateProfit(ind + 1,0,Limit,Size,prices,DP);
            int NotBuy = CalculateProfit(ind + 1,1,Limit,Size,prices,DP);
            profit = Math.max(BuyStock,NotBuy);
        }
        else{
            int Sell = prices[ind] + CalculateProfit(ind + 1,1,Limit - 1,Size,prices,DP);
            int NotSell = CalculateProfit(ind + 1,0,Limit,Size,prices,DP);
            profit = Math.max(Sell,NotSell);
        }

        DP[ind][buy][Limit] = profit;

        return DP[ind][buy][Limit];
    }
    public static void main(String[] args) {
        int[]prices = {2,4,1};
        int k = 2;
        System.out.print(BuyStocks(k,prices));
    }
}
