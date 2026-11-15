import java.util.*;
public class Buy_Stock_LT121 {

    private static int MaxProfit(int[]prices){
        int n = prices.length;
        int min = prices[0];
        int profit = 0;

        for(int index = 1; index < n; index++){
            int cost = prices[index] - min;
            profit = Math.max(profit,cost);
            min = Math.min(prices[index],min);
        }
        return profit;
    }
    public static void main(String[] args) {
        int []prices = {7,1,2,3,5,6,4};

        System.out.print(MaxProfit(prices));
    }
}
