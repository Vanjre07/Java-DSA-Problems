import java.util.*;
public class Partial_Knapsack {
    public static double Knapsack(int[]val,int[]wt,long cap){
        int size = val.length;
        double [][]items = new double[size][2];

        for(int index = 0; index < size; index++){
            items[index][0] = val[index];
            items[index][1] = wt[index];
        }

        Arrays.sort(items,(a,b) -> Double.compare(b[0]/b[1],a[0]/a[1]));
        double totalValue = 0.0;
        for(int index = 0; index < size; index++){
            double value = items[index][0];
            double weight = items[index][1];

            if(cap >= weight){
                totalValue += value;
                cap -= weight;
            }
            else{
                totalValue += (value/weight) * cap;
                break;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        long capacity = 50;

        double maxValue = Knapsack(values, weights, capacity);
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
