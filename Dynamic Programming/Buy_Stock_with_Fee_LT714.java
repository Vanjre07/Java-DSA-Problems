import java.util.*;
public class Buy_Stock_with_Fee_LT714 {

    public static int BuyStock(int[]prices,int fee){
        int size = prices.length;
        int[][]DP = new int[size][2];

        for(int[]firstRow : DP){
            Arrays.fill(firstRow,-1);
        }

        return Calculate(0,1,size,fee,prices,DP);
    }

    private static int Calculate(int ind,int buy,int size,int fee,int[]prices,int [][]DP){
        if(ind == size)
            return 0;

        if(DP[ind][buy] != -1)
            return DP[ind][buy];

        int profit;

        if(buy == 1){
            int Buy = -prices[ind] + Calculate(ind + 1,0,size,fee,prices,DP);
            int NotBuy = Calculate(ind + 1,1,size,fee,prices,DP);

            profit = Math.max(Buy,NotBuy);
        }
        else{
            int Sell = (prices[ind] + Calculate(ind + 1,1,size,fee,prices,DP) - fee);
            int NotSell = Calculate(ind + 1,0,size,fee,prices,DP);

            profit = Math.max(Sell,NotSell);
        }

        DP[ind][buy] = profit;
        return DP[ind][buy];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println("Maximum profit: " + BuyStock(prices, fee));
    }
}
